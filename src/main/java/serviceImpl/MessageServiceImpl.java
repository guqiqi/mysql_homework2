package serviceImpl;

import constant.CommenCost;
import constant.MessageType;
import dao.RealTimeRecordDao;
import daoImpl.MessageRecordDaoImpl;
import daoImpl.RealTimeRecordDaoImpl;
import entity.MessageRecordEntity;
import entity.RealTimeRecordEntity;
import service.MessageService;

import java.sql.Timestamp;

public class MessageServiceImpl implements MessageService {
    public MessageRecordEntity generateMessageRecord(String phoneNumber, Timestamp time, MessageType type) {
        MessageRecordEntity messageRecordEntity;

        if (type == MessageType.RECEIVE) {
            messageRecordEntity = new MessageRecordEntity(phoneNumber, type, time, 0.0);
            new MessageRecordDaoImpl().add(messageRecordEntity);
        } else {
            RealTimeRecordDao realTimeRecordDao = new RealTimeRecordDaoImpl();
            RealTimeRecordEntity realTimeRecordEntity = realTimeRecordDao.getRealTimeRecordByPhoneNumber(phoneNumber);

            if (realTimeRecordEntity.getBaseMessage() > realTimeRecordEntity.getMessage()) {
                messageRecordEntity = new MessageRecordEntity(phoneNumber, type, time, 0.0);
                new MessageRecordDaoImpl().add(messageRecordEntity);

                realTimeRecordDao.updateMessage(realTimeRecordEntity.getPhoneNumber(), realTimeRecordEntity.getMessage() + 1, realTimeRecordEntity.getMessageCost());
            } else {
                messageRecordEntity = new MessageRecordEntity(phoneNumber, type, time, CommenCost.MESSAGE);
                new MessageRecordDaoImpl().add(messageRecordEntity);

                realTimeRecordDao.updateMessage(realTimeRecordEntity.getPhoneNumber(), realTimeRecordEntity.getMessage() + 1, realTimeRecordEntity.getMessageCost() + CommenCost.MESSAGE);
            }
        }

        return messageRecordEntity;
    }
}
