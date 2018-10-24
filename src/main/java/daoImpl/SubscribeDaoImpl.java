package daoImpl;

import dao.SubscribeDao;
import entity.SubscribeRecordEntity;
import entity.SubscribeRelationEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.DaoUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubscribeDaoImpl extends DaoUtil implements SubscribeDao {
    public List<SubscribeRecordEntity> getSubscribeRecordByPhoneNumber(String phoneNumber) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        List<SubscribeRecordEntity> list = new ArrayList<SubscribeRecordEntity>();
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("from SubscribeRecordEntity where phoneNumber = ?");
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

        return list;
    }

    public void modifyPlanEndTime(String phoneNumber, Integer planId, Timestamp endTime) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE SubscribeRelationEntity SET endTime = ? WHERE phoneNumber = ? AND planId = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, endTime);
            query.setParameter(1, phoneNumber);
            query.setParameter(2, planId);
            //3、提交更新
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    // 删除过期的套餐订阅
    public void deleteExpireRelation() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        List<SubscribeRelationEntity> list = new ArrayList<SubscribeRelationEntity>();
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 得到Query对象，并写入hql语句
            Query query = session.createQuery("from SubscribeRelationEntity where endTime<>null");
            // 使用Query对象的list方法得到数据集合
            list = query.list();

            // 删除已经过期的套餐订阅
            for (SubscribeRelationEntity entity: list){
                if(entity.getEndTime().before(new Date()))
                    session.delete(entity);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
