package serviceImpl;

import daoImpl.BillRecordDaoImpl;
import daoImpl.RealTimeRecordDaoImpl;
import daoImpl.SubscribeDaoImpl;
import service.ScheduleService;

import java.util.Date;

// 每个月更新的逻辑（刷新套餐订阅情况、计算话费、更新）
public class ScheduleServiceImpl implements ScheduleService {
    public void refreshMonthlyBill() {
        // 先刷新套餐订阅情况
        new SubscribeDaoImpl().deleteExpireRelation();

        // 后生成账单并刷新当月账单
        new RealTimeRecordDaoImpl().refreshMonthlyRecord();
    }
}
