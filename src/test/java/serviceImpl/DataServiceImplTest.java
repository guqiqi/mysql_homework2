package serviceImpl;

import constant.DataType;
import helper.TimeHelper;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class DataServiceImplTest {

    @Test
    public void generateDataRecord() {
        for (int i = 0; i < 100; i++) {
            int lasting = new java.util.Random().nextInt(10240);
            Date randomDate = TimeHelper.randomDate("2018-10-01", "2018-10-30");
            DataType type = new java.util.Random().nextInt(2) == 0 ? DataType.LOCAL : DataType.NATIONAL;
            String[] numbers = {"13700000001", "13700000002", "13700000003", "13700000004", "13700000005"};
            String number = numbers[new java.util.Random().nextInt(5)];
            new DataServiceImpl().generateDataRecord(number, new Timestamp(randomDate.getTime()), type, lasting);
        }
    }
}