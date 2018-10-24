package service;

import constant.SubscribeEffectType;
import entity.BillRecordEntity;
import entity.RealTimeRecordEntity;
import entity.SubscribeRecordEntity;

import java.util.List;

public interface RecordService {
    public RealTimeRecordEntity generateBill(String phoneNumber);

    public List<BillRecordEntity> getHistoryBillRecord(String phoneNumber);

    public List<SubscribeRecordEntity> getSubscribeRecord(String phoneNumber);

    public void subscribePlan(Integer planId, String phoneNumber, SubscribeEffectType type);

    public void unsubscribePlan(Integer planId, String phoneNumber, SubscribeEffectType type);
}
