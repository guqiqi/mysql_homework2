package dao;

import entity.RealTimeRecordEntity;

// 实时话费记录
public interface RealTimeRecordDao {
    public RealTimeRecordEntity getRealTimeRecordByPhoneNumber(String phoneNumber);

    public void updateCalling(String phoneNumber, Integer calling, Double callingCost);

    public void updateMessage(String phoneNumber, Integer message, Double messageCost);

    public void updateLocalData(String phoneNumber, Integer data, Double dataCost);

    public void updateNationalData(String phoneNumber, Integer data, Double dataCost);

    public void updatePlan(String phoneNumber, Double baseCost, Integer baseCalling, Integer baseMessage, Integer
            baseLocalData, Integer baseNationalData);

    public void updateCallingPlan(String phoneNumber, Double baseCost, Integer baseCalling);

    public void updateMessagePlan(String phoneNumber, Double baseCost, Integer baseMessage);

    public void updateLocalDataPlan(String phoneNumber, Double baseCost, Integer baseLocalData);

    public void updateNationalDataPlan(String phoneNumber, Double baseCost, Integer baseNationalData);

    // 一键清空
    public void refreshMonthlyRecord();
}
