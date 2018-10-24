package dao;

import entity.BillRecordEntity;

import java.util.List;

// 账单
public interface BillRecordDao {
    public List<BillRecordEntity> getBillRecordByPhoneNumber(String phoneNumber);
}
