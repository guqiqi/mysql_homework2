package dao;

import entity.MessageRecordEntity;

import java.util.List;

// 短信记录
public interface MessageRecordDao {
    public List<MessageRecordEntity> getMessageRecordByPhoneNumber(String phoneNumber);
}
