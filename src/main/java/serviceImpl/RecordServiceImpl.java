package serviceImpl;

import constant.SubscribeEffectType;
import daoImpl.BillRecordDaoImpl;
import daoImpl.RealTimeRecordDaoImpl;
import daoImpl.SubscribeDaoImpl;
import entity.BillRecordEntity;
import entity.RealTimeRecordEntity;
import entity.SubscribeRecordEntity;
import service.RecordService;

import java.util.List;

public class RecordServiceImpl implements RecordService {
    public RealTimeRecordEntity generateBill(String phoneNumber) {
        return new RealTimeRecordDaoImpl().getRealTimeRecordByPhoneNumber(phoneNumber);
    }

    public List<BillRecordEntity> getHistoryBillRecord(String phoneNumber) {
        return new BillRecordDaoImpl().getBillRecordByPhoneNumber(phoneNumber);
    }

    public List<SubscribeRecordEntity> getSubscribeRecord(String phoneNumber) {
        return new SubscribeDaoImpl().getSubscribeRecordByPhoneNumber(phoneNumber);
    }

    public void subscribePlan(Integer planId, String phoneNumber, SubscribeEffectType type) {
        // TODO

    }

    public void unsubscribePlan(Integer planId, String phoneNumber, SubscribeEffectType type) {
        // TODO
    }
}
