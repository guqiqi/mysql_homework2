package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import constant.CallingType;

import java.sql.Timestamp;

public class TestCallingRecord {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务
    }

    @After
    public void destory() {
        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
    }

    @Test
    public void testGoods() {
        //生成对象
        CallingRecordEntity go = new CallingRecordEntity();
        go.setUserId("123231");
        System.out.println(CallingType.CALLED);
        go.setType(CallingType.CALLED);
        go.setId(102);
        go.setEndTime(new Timestamp(10000));


        //保存对象进数据库
        session.save(go);
//
//        CallingRecordEntity go1 = new CallingRecordEntity();
//        go1.setUserId("123231");
//        go1.setType(CallingType.DIALING);
//        go1.setId(9);
//        go1.setEndTime(new Timestamp(10000));
//        session.save(go1);

    }
}
