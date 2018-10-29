package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RealTimeRecordEntityTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务
    }

    @After
    public void tearDown() {
        transaction.commit();//事务提交
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
    }

    @Test
    public void testInsert() {
//        RealTimeRecordEntity realTimeRecordEntity = new RealTimeRecordEntity("13770758178", 20.0, 30.0, 30.0, 30.0, 10, 10, 10, 20, 20, 30, 30, 20);
        RealTimeRecordEntity realTimeRecordEntity = new RealTimeRecordEntity("13700000001");
        session.save(realTimeRecordEntity);
        realTimeRecordEntity = new RealTimeRecordEntity("13700000002");
        session.save(realTimeRecordEntity);
        realTimeRecordEntity = new RealTimeRecordEntity("13700000003");
        session.save(realTimeRecordEntity);
        realTimeRecordEntity = new RealTimeRecordEntity("13700000004");
        session.save(realTimeRecordEntity);
        realTimeRecordEntity = new RealTimeRecordEntity("13700000005");
        session.save(realTimeRecordEntity);
    }
}