package dao;

import entity.RealTimeRecordEntity;

import java.util.List;

// 实时话费记录
public interface RealTimeRecordDao {
    public RealTimeRecordEntity getRealTimeRecordByPhoneNumber(String phoneNumber);

    public void updateCalling(String phoneNumber, Integer calling, Double callingCost);

    public void updateMessage(String phoneNumber, Integer message, Double messageCost);

    public void updateLocalData(String phoneNumber, Integer data, Double dataCost);

    public void updateNationalData(String phoneNumber, Integer data, Double dataCost);

    // 一键清空
    public void refreshMonthlyRecord();
}
