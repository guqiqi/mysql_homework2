package service;

import constant.MessageType;
import entity.MessageRecordEntity;

import java.sql.Timestamp;

public interface MessageService {
    public MessageRecordEntity generateMessageRecord(String phoneNumber, Timestamp time, MessageType type);
}
