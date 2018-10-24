package dao;

import entity.SubscribeRecordEntity;

import java.util.List;

// 套餐订阅记录
public interface SubscribeDao {
    public List<SubscribeRecordEntity> getSubscribeRecordByPhoneNumber(String phoneNumber);
}
