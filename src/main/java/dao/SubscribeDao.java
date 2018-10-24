package dao;

import entity.SubscribeRecordEntity;

import java.sql.Timestamp;
import java.util.List;

// 套餐订阅记录
public interface SubscribeDao {
    public List<SubscribeRecordEntity> getSubscribeRecordByPhoneNumber(String phoneNumber);

    public void modifyPlanEndTime(String phoneNumber, Integer planId, Timestamp endTime);

    // 每月初自动查询过期的订阅关系
    public void deleteExpireRelation();
}
