package daoImpl;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class SubscribeDaoImplTest {
    @Test
    public void modifyPlanEndTime() {
        new SubscribeDaoImpl().modifyPlanEndTime("1", 1, new Timestamp(new Date().getTime()));
    }

    @Test
    public void deleteExpireRelation() {
        new SubscribeDaoImpl().deleteExpireRelation();
    }
}