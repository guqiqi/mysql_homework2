package serviceImpl;

import constant.MessageType;
import helper.TimeHelper;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class MessageServiceImplTest {

    @Test
    public void generateMessageRecord() {
        for (int i = 0; i < 100; i++) {
            Date randomDate = TimeHelper.randomDate("2018-10-01", "2018-10-30");
            MessageType type = new java.util.Random().nextInt(2) == 0 ? MessageType.RECEIVE : MessageType.SEND;
            String[] numbers = {"13700000001", "13700000002", "13700000003", "13700000004", "13700000005"};
            String number = numbers[new java.util.Random().nextInt(5)];
            new MessageServiceImpl().generateMessageRecord(number, new Timestamp(randomDate.getTime()), type);
        }
    }
}