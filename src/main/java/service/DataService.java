package service;

import constant.DataType;
import entity.DataRecordEntity;

import java.sql.Timestamp;

public interface DataService {
    public DataRecordEntity generateDataRecord(String phoneNumber, Timestamp time, DataType type, Integer amount);
}
