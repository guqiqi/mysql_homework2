package daoImpl;

import dao.MessageRecordDao;
import entity.MessageRecordEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.DaoUtil;

import java.util.ArrayList;
import java.util.List;

public class MessageRecordDaoImpl extends DaoUtil implements MessageRecordDao{
    public List<MessageRecordEntity> getMessageRecordByPhoneNumber(String phoneNumber) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        List<MessageRecordEntity> list = new ArrayList<MessageRecordEntity>();

        long startTime=System.currentTimeMillis();
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("from MessageRecordEntity where phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, phoneNumber);
            //3、使用Query对象的list方法得到数据集合
            list = query.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");

        return list;
    }
}
