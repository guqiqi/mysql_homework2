package serviceImpl;

import constant.CallingType;
import helper.TimeHelper;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class CallingServiceImplTest {
    @Test
    public void generateCallingRecord() {
        for (int i = 0; i < 100; i++) {
            Date randomDate = TimeHelper.randomDate("2018-09-29", "2018-10-30");
            int lasting = new java.util.Random().nextInt(720);
            CallingType type = new java.util.Random().nextInt(2) == 0 ? CallingType.DIALING : CallingType.CALLED;
            String[] numbers = {"13700000001", "13700000002", "13700000003", "13700000004", "13700000005"};
            String number = numbers[new java.util.Random().nextInt(5)];
            new CallingServiceImpl().generateCallingRecord(number, new Timestamp(randomDate.getTime()), lasting, type);
        }
    }
}