package entity;

import javax.persistence.*;

@Entity
@Table(name = "plan", schema = "mysql_homework2")
public class PlanEntity {
    private Integer planId;
    private Double baseCost;
    private Integer baseCalling;
    private Integer baseMessage;
    private Integer baseLocalUsage;
    private Integer baseNationalUsage;

    @Id
    @Column(name = "plan_id")
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "base_cost")
    public Double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Double baseCost) {
        this.baseCost = baseCost;
    }

    @Basic
    @Column(name = "base_calling")
    public Integer getBaseCalling() {
        return baseCalling;
    }

    public void setBaseCalling(Integer baseCalling) {
        this.baseCalling = baseCalling;
    }

    @Basic
    @Column(name = "base_message")
    public Integer getBaseMessage() {
        return baseMessage;
    }

    public void setBaseMessage(Integer baseMessage) {
        this.baseMessage = baseMessage;
    }

    @Basic
    @Column(name = "base_local_usage")
    public Integer getBaseLocalUsage() {
        return baseLocalUsage;
    }

    public void setBaseLocalUsage(Integer baseLocalUsage) {
        this.baseLocalUsage = baseLocalUsage;
    }

    @Basic
    @Column(name = "base_national_usage")
    public Integer getBaseNationalUsage() {
        return baseNationalUsage;
    }

    public void setBaseNationalUsage(Integer baseNationalUsage) {
        this.baseNationalUsage = baseNationalUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanEntity that = (PlanEntity) o;

        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (baseCost != null ? !baseCost.equals(that.baseCost) : that.baseCost != null) return false;
        if (baseCalling != null ? !baseCalling.equals(that.baseCalling) : that.baseCalling != null) return false;
        if (baseMessage != null ? !baseMessage.equals(that.baseMessage) : that.baseMessage != null) return false;
        if (baseLocalUsage != null ? !baseLocalUsage.equals(that.baseLocalUsage) : that.baseLocalUsage != null)
            return false;
        if (baseNationalUsage != null ? !baseNationalUsage.equals(that.baseNationalUsage) : that.baseNationalUsage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planId != null ? planId.hashCode() : 0;
        result = 31 * result + (baseCost != null ? baseCost.hashCode() : 0);
        result = 31 * result + (baseCalling != null ? baseCalling.hashCode() : 0);
        result = 31 * result + (baseMessage != null ? baseMessage.hashCode() : 0);
        result = 31 * result + (baseLocalUsage != null ? baseLocalUsage.hashCode() : 0);
        result = 31 * result + (baseNationalUsage != null ? baseNationalUsage.hashCode() : 0);
        return result;
    }
}
