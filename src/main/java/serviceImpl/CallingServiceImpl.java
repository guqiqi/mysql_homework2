package serviceImpl;

import constant.CallingType;
import constant.CommenCost;
import dao.RealTimeRecordDao;
import daoImpl.CallingRecordDaoImpl;
import daoImpl.RealTimeRecordDaoImpl;
import entity.CallingRecordEntity;
import entity.RealTimeRecordEntity;
import service.CallingService;

import java.sql.Timestamp;

public class CallingServiceImpl implements CallingService {

    /**
     * modify real time record in minute
     *
     * @param phoneNumber phoneNumber
     * @param time        call time
     * @param lastingTime lasting time, count in seconds
     * @param type        dialing or called
     * @return
     */
    public CallingRecordEntity generateCallingRecord(String phoneNumber, Timestamp time, Integer lastingTime, CallingType type) {
        CallingRecordEntity callingRecordEntity;

        if (type == CallingType.CALLED) {
            callingRecordEntity = new CallingRecordEntity(phoneNumber, type, time, lastingTime, 0.0);
            new CallingRecordDaoImpl().add(callingRecordEntity);
        } else {
            RealTimeRecordDao realTimeRecordDao = new RealTimeRecordDaoImpl();
            RealTimeRecordEntity realTimeRecordEntity = realTimeRecordDao.getRealTimeRecordByPhoneNumber(phoneNumber);

            // 计算实际按分钟的时长
            int minute = lastingTime / 60 + 1;
            if (lastingTime % 60 > 55)
                minute = minute + 1;

            if (realTimeRecordEntity.getBaseCalling() >= realTimeRecordEntity.getCalling() + minute) {
                callingRecordEntity = new CallingRecordEntity(phoneNumber, type, time, lastingTime, 0.0);
                new CallingRecordDaoImpl().add(callingRecordEntity);

                realTimeRecordDao.updateCalling(realTimeRecordEntity.getPhoneNumber(), realTimeRecordEntity.getCalling() + minute, realTimeRecordEntity.getCallingCost());
            } else {
                double cost = CommenCost.CALLING * (minute - realTimeRecordEntity.getBaseCalling() + realTimeRecordEntity.getCalling());

                callingRecordEntity = new CallingRecordEntity(phoneNumber, type, time, lastingTime, cost);
                new CallingRecordDaoImpl().add(callingRecordEntity);

                realTimeRecordDao.updateCalling(realTimeRecordEntity.getPhoneNumber(), realTimeRecordEntity.getCalling() + minute, realTimeRecordEntity.getCallingCost() + cost);
            }
        }

        return callingRecordEntity;
    }
}
