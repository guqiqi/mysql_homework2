package daoImpl;

import dao.CallingRecordDao;
import entity.BillRecordEntity;
import entity.CallingRecordEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import util.DaoUtil;

import java.util.ArrayList;
import java.util.List;

public class CallingRecordDaoImpl extends DaoUtil implements CallingRecordDao {
    public List<CallingRecordEntity> getCallingRecordByPhoneNumber(String phoneNumber) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        List<CallingRecordEntity> list = new ArrayList<CallingRecordEntity>();
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            // 1、得到Query对象，并写入hql语句
            Query query = session.createQuery("from CallingRecordEntity where phoneNumber = ?");
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
}
