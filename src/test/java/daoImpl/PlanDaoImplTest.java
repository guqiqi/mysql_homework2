package daoImpl;

import entity.PlanEntity;
import org.junit.Test;

public class PlanDaoImplTest {

    @Test
    public void add() {
        PlanEntity planEntity = new PlanEntity(20.0, 20, 30, 50, 30);
        new MessageRecordDaoImpl().add(planEntity);
    }

    @Test
    public void findPlanById() {
        System.out.println(new PlanDaoImpl().findPlanById(2).getBaseLocalUsage());
    }
}