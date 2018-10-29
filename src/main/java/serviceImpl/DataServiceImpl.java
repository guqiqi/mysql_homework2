package serviceImpl;

import constant.CommenCost;
import constant.DataType;
import dao.RealTimeRecordDao;
import daoImpl.DataRecordDaoImpl;
import daoImpl.RealTimeRecordDaoImpl;
import entity.DataRecordEntity;
import entity.RealTimeRecordEntity;
import service.DataService;

import java.sql.Timestamp;

public class DataServiceImpl implements DataService {
    public DataRecordEntity generateDataRecord(String phoneNumber, Timestamp time, DataType type, Integer amount) {
        DataRecordEntity dataRecordEntity;

        RealTimeRecordDao realTimeRecordDao = new RealTimeRecordDaoImpl();
        RealTimeRecordEntity realTimeRecordEntity = realTimeRecordDao.getRealTimeRecordByPhoneNumber(phoneNumber);

        if (type == DataType.LOCAL) {
            if (realTimeRecordEntity.getBaseLocalData() * 1024 >= realTimeRecordEntity.getLocalData() + amount) {
                dataRecordEntity = new DataRecordEntity(phoneNumber, type, time, amount, 0.0);
                new DataRecordDaoImpl().add(dataRecordEntity);

                realTimeRecordDao.updateLocalData(realTimeRecordEntity.getPhoneNumber(), realTimeRecordEntity.getLocalData() + amount, realTimeRecordEntity.getDataCost());
            } else {
                double cost = CommenCost.LOCAL_DATA / 1024 * (amount - realTimeRecordEntity.getBaseLocalData() + realTimeRecordEntity.getLocalData());

                dataRecordEntity = new DataRecordEntity(phoneNumber, type, time, amount, cost);
                new DataRecordDaoImpl().add(dataRecordEntity);

                realTimeRecordDao.updateLocalData(realTimeRecordEntity.getPhoneNumber(), realTimeRecordEntity.getLocalData() + amount, realTimeRecordEntity.getDataCost() + cost);
            }
        } else {
            if (realTimeRecordEntity.getBaseNationalData() * 1024 >= realTimeRecordEntity.getNationalData() + amount) {
                dataRecordEntity = new DataRecordEntity(phoneNumber, type, time, amount, 0.0);
                new DataRecordDaoImpl().add(dataRecordEntity);

                realTimeRecordDao.updateNationalData(realTimeRecordEntity.getPhoneNumber(), realTimeRecordEntity.getNationalData() + amount, realTimeRecordEntity.getDataCost());
            } else {
                double cost = CommenCost.NATIONAL_DATA / 1024 * (amount - realTimeRecordEntity.getBaseNationalData() + realTimeRecordEntity.getNationalData());

                dataRecordEntity = new DataRecordEntity(phoneNumber, type, time, amount, cost);
                new DataRecordDaoImpl().add(dataRecordEntity);

                realTimeRecordDao.updateNationalData(realTimeRecordEntity.getPhoneNumber(), realTimeRecordEntity.getNationalData() + amount, realTimeRecordEntity.getDataCost() + cost);
            }
        }

        return dataRecordEntity;
    }
}
