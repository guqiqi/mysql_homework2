package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DaoUtil {
    public void add(Object object){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        Session session = sessionFactory.openSession();//创建会话

        session.save(object);

        session.beginTransaction().commit();
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
    }

    public void delete(Object object){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        Session session = sessionFactory.openSession();//创建会话
        Transaction tran=session.beginTransaction();

        session.delete(object);

        tran.commit();
    }
}
