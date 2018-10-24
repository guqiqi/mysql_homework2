package serviceImpl;

import constant.SubscribeEffectType;
import entity.BillRecordEntity;
import entity.RealTimeRecordEntity;
import entity.SubscribeRecordEntity;
import service.RecordService;

import java.util.List;

public class RecordServiceImpl implements RecordService {
    public RealTimeRecordEntity generateBill(String phoneNumber) {
        return null;
    }

    public List<BillRecordEntity> getHistoryBillRecord(String phoneNumber) {
        return null;
    }

    public List<SubscribeRecordEntity> getSubscribeRecord(String phoneNumber) {
        return null;
    }

    public void subscribePlan(Integer planId, String phoneNumber, SubscribeEffectType type) {

    }

    public void unsubscribePlan(Integer planId, String phoneNumber, SubscribeEffectType type) {

    }
}
