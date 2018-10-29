package daoImpl;

import dao.PlanDao;
import entity.PlanEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.DaoUtil;

public class PlanDaoImpl extends DaoUtil implements PlanDao {
    public PlanEntity findPlanById(Integer id) {
        SessionFactory sessionFactory = null;
        Session session = null;
        PlanEntity planEntity = new PlanEntity();

        long startTime=System.currentTimeMillis();
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();

            planEntity = session.get(PlanEntity.class, id);
        } catch (Exception e) {
        } finally {
            session.close();
            sessionFactory.close();
        }

        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");

        return planEntity;
    }
}
