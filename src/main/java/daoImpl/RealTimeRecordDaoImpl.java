package daoImpl;

import dao.RealTimeRecordDao;
import entity.BillRecordEntity;
import entity.RealTimeRecordEntity;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.DaoUtil;
import util.DateUtil;

import java.sql.Date;
import java.util.List;

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

    public void updatePlan(String phoneNumber, Double baseCost, Integer baseCalling, Integer baseMessage, Integer
            baseLocalData, Integer baseNationalData) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.baseCost = ?, r.baseCalling = ?, " +
                    "r.baseMessage = ?, r.baseLocalData = ?, r.baseNationalData = ? where r .phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, baseCost);
            query.setParameter(1, baseCalling);
            query.setParameter(2, baseMessage);
            query.setParameter(3, baseLocalData);
            query.setParameter(4, baseNationalData);
            query.setParameter(5, phoneNumber);
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

    public void updateCallingPlan(String phoneNumber, Double baseCost, Integer baseCalling) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.baseCost = ?, r.baseCalling = ? " +
                    "where r .phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, baseCost);
            query.setParameter(1, baseCalling);
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

    public void updateMessagePlan(String phoneNumber, Double baseCost, Integer baseMessage) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.baseCost = ?, r.baseMessage = ? " +
                    "where r .phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, baseCost);
            query.setParameter(1, baseMessage);
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

    public void updateLocalDataPlan(String phoneNumber, Double baseCost, Integer baseLocalData) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.baseCost = ?, r.baseLocalData = ? " +
                    "where r .phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, baseCost);
            query.setParameter(1, baseLocalData);
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

    public void updateNationalDataPlan(String phoneNumber, Double baseCost, Integer baseNationalData) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.baseCost = ?, r.baseNationalData = ? " +
                    "where r .phoneNumber = ?");
            //2、填写上一步中占位符的内容
            query.setParameter(0, baseCost);
            query.setParameter(1, baseNationalData);
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
        // 套餐订阅情况更新完之后更新
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 生成每个月账单
            Query query = session.createQuery("SELECT new BillRecordEntity(r.phoneNumber, r.baseCost, r.callingCost, r.messageCost, r.dataCost) " +
                    "from RealTimeRecordEntity r");
            List<BillRecordEntity> billList = query.list();

            for (BillRecordEntity entity: billList){
                entity.setTime(new Date(DateUtil.getFirstDayOfMonth().getTime()));
                session.save(entity);
            }

            // 每个人都要刷新账单
            query = session.createQuery("FROM UserEntity");
            List<UserEntity> userEntityList = query.list();
            for (UserEntity entity : userEntityList) {
                query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.baseCost = 0.0, r.baseCalling =" +
                        " 0, r.baseMessage = 0, r.baseLocalData = 0, r.baseNationalData = 0, r.callingCost = 0.0, r" +
                        ".messageCost = 0.0, r.dataCost = 0.0, r.calling = 0,  r.message = 0, r.localData = 0, r" +
                        ".nationalData = 0" +
                        "where r.phoneNumber = ?");
                query.setParameter(0, entity.getPhoneNumber());
                query.executeUpdate();
            }

            // 根据套餐再次刷新
            query = session.createQuery("SELECT new RealTimeRecordEntity (s.phoneNumber, SUM(p.baseCost), SUM(p" +
                    ".baseCalling), " +
                    "SUM(p.baseMessage), SUM(p.baseLocalUsage), SUM(p.baseNationalUsage)) FROM " +
                    "SubscribeRelationEntity s, " +
                    "PlanEntity p WHERE s.planId = p.planId GROUP BY s.phoneNumber");

            // 得到每个人订阅的套餐总和
            List<RealTimeRecordEntity> list = query.list();
            System.out.println(list.size());

            for (RealTimeRecordEntity entity : list) {
                query = session.createQuery("UPDATE RealTimeRecordEntity r SET r.baseCost = ?, r.baseCalling =" +
                        " ?, r.baseMessage = ?, r.baseLocalData = ?, r.baseNationalData = ?, r.callingCost = 0.0, r" +
                        ".messageCost = 0.0, r.dataCost = 0.0, r.calling = 0,  r.message = 0, r.localData = 0, r" +
                        ".nationalData = 0" +
                        "where r.phoneNumber = ?");
                // 填写上一步中占位符的内容
                query.setParameter(0, entity.getBaseCost());
                query.setParameter(1, entity.getBaseCalling());
                query.setParameter(2, entity.getBaseMessage());
                query.setParameter(3, entity.getBaseLocalData());
                query.setParameter(4, entity.getBaseNationalData());
                query.setParameter(5, entity.getPhoneNumber());
                System.out.println(entity.getPhoneNumber());
                query.executeUpdate();
            }

            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

