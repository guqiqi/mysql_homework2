package dao;

import entity.RealTimeRecordEntity;

import java.util.List;

// 实时话费记录
public interface RealTimeRecordDao {
    public List<RealTimeRecordEntity> getRealTimeRecordByPhoneNumber(String phoneNumber);
}
