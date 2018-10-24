package daoImpl;

import constant.MessageType;
import entity.MessageRecordEntity;
import org.junit.Test;

import java.sql.Timestamp;

public class MessageRecordDaoImplTest {

    @Test
    public void add() {
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity("13770758178", MessageType.SEND, new Timestamp(200000), 30.0);
        new MessageRecordDaoImpl().add(messageRecordEntity);
    }

    @Test
    public void getMessageRecordByPhoneNumber() {
        System.out.println(new MessageRecordDaoImpl().getMessageRecordByPhoneNumber("13770758178").size());
    }
}