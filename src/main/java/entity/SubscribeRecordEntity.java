package entity;

import constant.SubscribeEffectType;
import constant.SubscribeOperationType;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "subscribe_record", schema = "mysql_homework2")
public class SubscribeRecordEntity {
    private Integer id;
    private String phoneNumber;
    private Timestamp time;
    private Integer planId;
    private SubscribeOperationType operationType;
    private SubscribeEffectType effectType;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "plan_id")
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    public SubscribeOperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(SubscribeOperationType operationType) {
        this.operationType = operationType;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "effect_type")
    public SubscribeEffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(SubscribeEffectType effectType) {
        this.effectType = effectType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscribeRecordEntity that = (SubscribeRecordEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (operationType != null ? !operationType.equals(that.operationType) : that.operationType != null)
            return false;
        if (effectType != null ? !effectType.equals(that.effectType) : that.effectType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (operationType != null ? operationType.hashCode() : 0);
        result = 31 * result + (effectType != null ? effectType.hashCode() : 0);
        return result;
    }
}
