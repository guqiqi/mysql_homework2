package serviceImpl;

import constant.SubscribeEffectType;
import entity.SubscribeRecordEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RecordServiceImplTest {

    @Test
    public void generateBill() {
    }

    @Test
    public void getHistoryBillRecord() {
    }

    @Test
    public void getSubscribeRecord() {
        RecordServiceImpl recordService = new RecordServiceImpl();
        List<SubscribeRecordEntity> list = recordService.getSubscribeRecord("13700000001");
        for(SubscribeRecordEntity entity: list){
            System.out.println("时间: " + entity.getTime() + " 操作: " + entity.getOperationType() + " 生效方式: " + entity
                    .getEffectType());
        }
    }

    @Test
    public void subscribePlan() {
        RecordServiceImpl recordService = new RecordServiceImpl();
        recordService.subscribePlan(1, "13700000001", SubscribeEffectType.IMMEDIATE);
        recordService.subscribePlan(5, "13700000001", SubscribeEffectType.NEXTMONTH);
        recordService.subscribePlan(3, "13700000002", SubscribeEffectType.IMMEDIATE);
        recordService.subscribePlan(4, "13700000003", SubscribeEffectType.IMMEDIATE);
        recordService.subscribePlan(4, "13700000004", SubscribeEffectType.NEXTMONTH);
        recordService.subscribePlan(5, "13700000005", SubscribeEffectType.IMMEDIATE);
        recordService.subscribePlan(6, "13700000005", SubscribeEffectType.IMMEDIATE);
    }

    @Test
    public void unsubscribePlan() {
    }
}