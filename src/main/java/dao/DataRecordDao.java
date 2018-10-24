package dao;

import entity.DataRecordEntity;

import java.util.List;

// 上网记录
public interface DataRecordDao {
    public List<DataRecordEntity> getDataRecordByPhoneNumber(String phoneNumber);
}
