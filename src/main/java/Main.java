import constant.CallingType;
import constant.DataType;
import constant.MessageType;
import constant.SubscribeEffectType;
import entity.*;
import service.RecordService;
import serviceImpl.CallingServiceImpl;
import serviceImpl.DataServiceImpl;
import serviceImpl.MessageServiceImpl;
import serviceImpl.RecordServiceImpl;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumberFormat df = NumberFormat.getNumberInstance();
        // 保留两位小数
        df.setMaximumFractionDigits(2);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        RecordService recordService = new RecordServiceImpl();

        // 查询套餐订阅历史
        List<SubscribeRecordEntity> subscribeRecordEntityList = recordService.getSubscribeRecord("13700000003");
        for (SubscribeRecordEntity entity : subscribeRecordEntityList) {
            System.out.println(entity.getPhoneNumber() + "  " + entity.getTime() + "  " + entity.getOperationType() +
                    " plan" + entity.getPlanId() + " " + entity.getEffectType());
        }

        // 订阅
        recordService.subscribePlan(5, "13700000002", SubscribeEffectType.IMMEDIATE);

        // 退订
        recordService.unsubscribePlan(4, "13700000004", SubscribeEffectType.NEXTMONTH);

        // 通话
        CallingRecordEntity callingRecordEntity = new CallingServiceImpl().generateCallingRecord("13700000002", new
                Timestamp(new Date().getTime()), 56, CallingType.DIALING);
        System.out.println(callingRecordEntity.getPhoneNumber() + " " + callingRecordEntity.getTime() + " " +
                callingRecordEntity.getLastingTime() + "s cost ￥" + df.format(callingRecordEntity.getCost()));

        // 流量
        DataRecordEntity dataRecordEntity = new DataServiceImpl().generateDataRecord("13700000004", new
                Timestamp(new Date().getTime()), DataType.NATIONAL, 3000);
        System.out.println(dataRecordEntity.getPhoneNumber() + " " + dataRecordEntity.getTime() + " " +
                dataRecordEntity.getAmount() + "KB " + dataRecordEntity.getType() + " cost ￥" + df.format(dataRecordEntity.getCost()));

        // 短信
        MessageRecordEntity messageRecordEntity = new MessageServiceImpl().generateMessageRecord("13700000004", new
                Timestamp(new Date().getTime()), MessageType.SEND);
        System.out.println(messageRecordEntity.getPhoneNumber() + " " + messageRecordEntity.getTime() + " " +
                messageRecordEntity.getType() + " cost ￥" + df.format(messageRecordEntity.getCost()));

        // 月账单
        RealTimeRecordEntity realTimeRecordEntity = recordService.generateBill("13700000004");
        System.out.println("话费合计: " + df.format(realTimeRecordEntity.getBaseCost() + realTimeRecordEntity
                .getCallingCost() + realTimeRecordEntity.getMessageCost() + realTimeRecordEntity.getDataCost()) + " " +
                "套餐费用: " + df.format(realTimeRecordEntity.getBaseCost()) + " 通话费用:" + df.format(realTimeRecordEntity.getCallingCost()) +
                " 短信费用:" + df.format(realTimeRecordEntity.getMessageCost()) + " 流量费用:" + df.format(realTimeRecordEntity.getDataCost()));

        // 查询历史月账单
        List<BillRecordEntity> billRecordEntityList = recordService.getHistoryBillRecord("13700000001");
        for (BillRecordEntity entity : billRecordEntityList) {
            System.out.println(formatter.format(entity.getTime()) + " 话费合计: " + df.format(entity.getCost()) + " 套餐费用:" +
                    " " + df.format(entity.getBaseCost()) + " 通话费用:" + df.format(entity.getCallingCost()) + " 短信费用:"
                    + df.format(entity.getMessageCost()) + " 流量费用:" + df.format(entity.getDataCost()));
        }
    }
}
