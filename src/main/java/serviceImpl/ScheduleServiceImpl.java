package serviceImpl;

import daoImpl.BillRecordDaoImpl;
import daoImpl.RealTimeRecordDaoImpl;
import daoImpl.SubscribeDaoImpl;
import service.ScheduleService;

import java.util.Date;

public class ScheduleServiceImpl implements ScheduleService {
    public void generateMonthlyBill() {
        new BillRecordDaoImpl().generateBillRecord(new Date().getYear(), new Date().getMonth());
    }

    public void refreshMonthlyBill() {
        // 先刷套餐订阅情况
        new SubscribeDaoImpl().deleteExpireRelation();

        // 后刷新当月账单
        new RealTimeRecordDaoImpl().refreshMonthlyRecord();
    }
}
