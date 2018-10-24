package daoImpl;

import dao.RealTimeRecordDao;
import entity.RealTimeRecordEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.DaoUtil;

public class RealTimeRecordDaoImpl extends DaoUtil implements RealTimeRecordDao {
    public RealTimeRecordEntity getRealTimeRecordByPhoneNumber(String phoneNumber) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        RealTimeRecordEntity realTimeRecordEntity = new RealTimeRecordEntity();
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            realTimeRecordEntity = session.get(RealTimeRecordEntity.class, phoneNumber);
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
        return realTimeRecordEntity;
    }

    public void updateCalling(String phoneNumber, Integer calling, Double callingCost) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.calling = ?, r.callingCost = ? where phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, calling);
            query.setParameter(1, callingCost);
            query.setParameter(2, phoneNumber);
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

    public void updateMessage(String phoneNumber, Integer message, Double messageCost) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.message = ?, r.messageCost = ? where phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, message);
            query.setParameter(1, messageCost);
            query.setParameter(2, phoneNumber);
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

    public void updateLocalData(String phoneNumber, Integer data, Double dataCost) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.localData = ?, r.dataCost = ? where r.phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, data);
            query.setParameter(1, dataCost);
            query.setParameter(2, phoneNumber);
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

    public void updateNationalData(String phoneNumber, Integer data, Double dataCost) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.nationalData = ?, r.dataCost = ? where r.phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, data);
            query.setParameter(1, dataCost);
            query.setParameter(2, phoneNumber);
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

    public void refreshMonthlyRecord() {
        // TODO 涉及到套餐的设置
    }
}
