package daoImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class RealTimeRecordDaoImplTest {

    @Test
    public void refreshMonthlyRecord() {
        new RealTimeRecordDaoImpl().refreshMonthlyRecord();
    }
}