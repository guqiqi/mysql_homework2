package serviceImpl;

import constant.SubscribeEffectType;
import constant.SubscribeOperationType;
import dao.PlanDao;
import dao.RealTimeRecordDao;
import daoImpl.BillRecordDaoImpl;
import daoImpl.PlanDaoImpl;
import daoImpl.RealTimeRecordDaoImpl;
import daoImpl.SubscribeDaoImpl;
import entity.*;
import service.RecordService;
import util.DateUtil;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RecordServiceImpl implements RecordService {
    public RealTimeRecordEntity generateBill(String phoneNumber) {
        // 得到当月实时账单
        return new RealTimeRecordDaoImpl().getRealTimeRecordByPhoneNumber(phoneNumber);
    }

    public List<BillRecordEntity> getHistoryBillRecord(String phoneNumber) {
        return new BillRecordDaoImpl().getBillRecordByPhoneNumber(phoneNumber);
    }

    public List<SubscribeRecordEntity> getSubscribeRecord(String phoneNumber) {
        return new SubscribeDaoImpl().getSubscribeRecordByPhoneNumber(phoneNumber);
    }

    public void subscribePlan(Integer planId, String phoneNumber, SubscribeEffectType type) {
        SubscribeRelationEntity subscribeRelationEntity;
        SubscribeRecordEntity subscribeRecordEntity = new SubscribeRecordEntity(phoneNumber, new Timestamp(new Date()
                .getTime()), planId, SubscribeOperationType.SUBSCRIBE, type);
        if (type == SubscribeEffectType.IMMEDIATE) {
            subscribeRelationEntity = new SubscribeRelationEntity(phoneNumber, planId, new Timestamp(new Date()
                    .getTime()));

            // 立即生效需要修改实时话费
            PlanEntity planEntity = new PlanDaoImpl().findPlanById(planId);

            Calendar c = Calendar.getInstance();
            int day = c.get(Calendar.DAY_OF_MONTH);//获取当前天数
            int last = c.getActualMaximum(c.DAY_OF_MONTH);//获取本月最大天数
            double leftPercent = (double) (last - day) / (double) last;

            Double leftBaseCost = planEntity.getBaseCost() * leftPercent;
            Integer leftMessage = (int) (planEntity.getBaseMessage() * leftPercent);
            Integer leftCalling = (int) (planEntity.getBaseCalling() * leftPercent);
            Integer leftLocalData = (int) (planEntity.getBaseLocalUsage() * leftPercent);
            Integer leftNationalData = (int) (planEntity.getBaseNationalUsage() * leftPercent);

            RealTimeRecordDao realTimeRecordDao = new RealTimeRecordDaoImpl();
            RealTimeRecordEntity realTimeRecordEntity = realTimeRecordDao.getRealTimeRecordByPhoneNumber
                    (phoneNumber);
            realTimeRecordDao.updatePlan(phoneNumber, realTimeRecordEntity.getBaseCost() + leftBaseCost,
                    realTimeRecordEntity.getBaseCalling() + leftCalling,
                    realTimeRecordEntity.getBaseMessage() + leftMessage,
                    realTimeRecordEntity.getBaseLocalData() + leftLocalData,
                    realTimeRecordEntity.getBaseNationalData() + leftNationalData);

        } else {
            subscribeRelationEntity = new SubscribeRelationEntity(phoneNumber, planId, DateUtil.getFirstDayOfNextMonth());
        }

        SubscribeDaoImpl subscribeDao = new SubscribeDaoImpl();
        subscribeDao.add(subscribeRecordEntity);
        subscribeDao.add(subscribeRelationEntity);
    }

    public void unsubscribePlan(Integer planId, String phoneNumber, SubscribeEffectType type) {
        SubscribeDaoImpl subscribeDao = new SubscribeDaoImpl();
        SubscribeRecordEntity subscribeRecordEntity = new SubscribeRecordEntity(phoneNumber, new Timestamp(new Date()
                .getTime()), planId, SubscribeOperationType.UNSUBSCRIBE, type);
        if (type == SubscribeEffectType.IMMEDIATE) {
            subscribeDao.modifyPlanEndTime(phoneNumber, planId, new Timestamp(new Date().getTime()));
        } else {
            if (planId > 4) {
                System.out.println("Sorry, this plan cannot unsubscribe immediately!");
                return;
            }

            subscribeDao.modifyPlanEndTime(phoneNumber, planId, DateUtil.getLastDayOfMonth());

            // 立即退订退款问题
            PlanDao planDao = new PlanDaoImpl();
            PlanEntity planEntity = planDao.findPlanById(planId);
            RealTimeRecordDao realTimeRecordDao = new RealTimeRecordDaoImpl();
            RealTimeRecordEntity realTimeRecordEntity = realTimeRecordDao.getRealTimeRecordByPhoneNumber
                    (phoneNumber);

            switch (planEntity.getPlanId()) {
                case 1: {
                    if (realTimeRecordEntity.getBaseCalling() - realTimeRecordEntity.getCalling() > planEntity
                            .getBaseCalling() * (1 - DateUtil.getMonthRadio())) {
                        // 按日期退钱，减套餐
                        realTimeRecordDao.updateCallingPlan(phoneNumber, realTimeRecordEntity.getBaseCost() - planEntity
                                .getBaseCost() *
                                (1 - DateUtil.getMonthRadio()), realTimeRecordEntity.getBaseCalling() - (int) (planEntity
                                .getBaseCalling() *
                                (1 - DateUtil.getMonthRadio())));
                    } else {
                        // 按用量退钱，减套餐
                        int left = realTimeRecordEntity.getBaseCalling() - realTimeRecordEntity.getCalling();
                        double leftMoney = planEntity.getBaseCost() * left / planEntity.getBaseCalling();
                        realTimeRecordDao.updateCallingPlan(phoneNumber, realTimeRecordEntity.getBaseCost() - leftMoney,
                                realTimeRecordEntity.getCalling());
                    }
                }
                case 2: {
                    if (realTimeRecordEntity.getBaseMessage() - realTimeRecordEntity.getMessage() > planEntity
                            .getBaseMessage() * (1 - DateUtil.getMonthRadio())) {
                        // 按日期退钱，减套餐
                        realTimeRecordDao.updateMessagePlan(phoneNumber, realTimeRecordEntity.getBaseCost() - planEntity
                                .getBaseCost() *
                                (1 - DateUtil.getMonthRadio()), realTimeRecordEntity.getBaseMessage() - (int) (planEntity
                                .getBaseMessage() *
                                (1 - DateUtil.getMonthRadio())));
                    } else {
                        // 按用量退钱，减套餐
                        int left = realTimeRecordEntity.getBaseMessage() - realTimeRecordEntity.getMessage();
                        double leftMoney = planEntity.getBaseCost() * left / planEntity.getBaseMessage();
                        realTimeRecordDao.updateMessagePlan(phoneNumber, realTimeRecordEntity.getBaseCost() - leftMoney,
                                realTimeRecordEntity.getMessage());
                    }
                }
                case 3: {
                    if (realTimeRecordEntity.getBaseLocalData() - realTimeRecordEntity.getLocalData() > planEntity
                            .getBaseLocalUsage() * (1 - DateUtil.getMonthRadio())) {
                        // 按日期退钱，减套餐
                        realTimeRecordDao.updateLocalDataPlan(phoneNumber, realTimeRecordEntity.getBaseLocalData() -
                                planEntity
                                .getBaseLocalUsage() *
                                (1 - DateUtil.getMonthRadio()), realTimeRecordEntity.getBaseLocalData() - (int) (planEntity
                                .getBaseLocalUsage() *
                                (1 - DateUtil.getMonthRadio())));
                    } else {
                        // 按用量退钱，减套餐
                        int left = realTimeRecordEntity.getBaseLocalData() - realTimeRecordEntity.getLocalData();
                        double leftMoney = planEntity.getBaseCost() * left / planEntity.getBaseLocalUsage();
                        realTimeRecordDao.updateLocalDataPlan(phoneNumber, realTimeRecordEntity.getBaseCost() - leftMoney,
                                realTimeRecordEntity.getLocalData());
                    }
                }
                case 4: {
                    if (realTimeRecordEntity.getBaseNationalData() - realTimeRecordEntity.getNationalData() > planEntity
                            .getBaseNationalUsage() * (1 - DateUtil.getMonthRadio())) {
                        // 按日期退钱，减套餐
                        realTimeRecordDao.updateNationalDataPlan(phoneNumber, realTimeRecordEntity.getBaseNationalData() -
                                planEntity
                                        .getBaseNationalUsage() *
                                        (1 - DateUtil.getMonthRadio()), realTimeRecordEntity.getBaseNationalData() - (int)
                                (planEntity
                                .getBaseNationalUsage() *
                                (1 - DateUtil.getMonthRadio())));
                    } else {
                        // 按用量退钱，减套餐
                        int left = realTimeRecordEntity.getBaseNationalData() - realTimeRecordEntity.getNationalData();
                        double leftMoney = planEntity.getBaseCost() * left / planEntity.getBaseNationalUsage();
                        realTimeRecordDao.updateNationalDataPlan(phoneNumber, realTimeRecordEntity.getBaseCost() - leftMoney,
                                realTimeRecordEntity.getNationalData());
                    }
                }
            }
        }

        subscribeDao.add(subscribeRecordEntity);
    }
}
