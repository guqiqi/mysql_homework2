package dao;

import entity.PlanEntity;

// 套餐
public interface PlanDao {
    public PlanEntity findPlanById(Integer id);
}
