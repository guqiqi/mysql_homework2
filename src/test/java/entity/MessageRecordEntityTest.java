package entity;

import constant.MessageType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

public class MessageRecordEntityTest {
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
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity("13770758178", MessageType.RECEIVE, new Timestamp(200000), 30.0);
        session.save(messageRecordEntity);
    }

}