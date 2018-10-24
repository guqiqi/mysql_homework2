package dao;

import entity.CallingRecordEntity;

import java.util.List;

// 通话记录
public interface CallingRecordDao {
    public List<CallingRecordEntity> getCallingRecordByPhoneNumber(String phoneNumber);
}
