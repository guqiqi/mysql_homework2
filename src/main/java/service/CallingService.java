package service;

import constant.CallingType;
import entity.CallingRecordEntity;

import java.sql.Timestamp;

public interface CallingService {
    public CallingRecordEntity generateCallingRecord(String phoneNumber, Timestamp time, Integer lasting_time, CallingType type);
}
