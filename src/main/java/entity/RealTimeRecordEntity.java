package entity;

import javax.persistence.*;

@Entity
@Table(name = "real_time_record", schema = "mysql_homework2")
public class RealTimeRecordEntity {
    private String phoneNumber;
    private Double baseCost;
    private Double callingCost;
    private Double messageCost;
    private Double dataCost;

    @Id
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    @Column(name = "calling_cost")
    public Double getCallingCost() {
        return callingCost;
    }

    public void setCallingCost(Double callingCost) {
        this.callingCost = callingCost;
    }

    @Basic
    @Column(name = "message_cost")
    public Double getMessageCost() {
        return messageCost;
    }

    public void setMessageCost(Double messageCost) {
        this.messageCost = messageCost;
    }

    @Basic
    @Column(name = "data_cost")
    public Double getDataCost() {
        return dataCost;
    }

    public void setDataCost(Double dataCost) {
        this.dataCost = dataCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RealTimeRecordEntity that = (RealTimeRecordEntity) o;

        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (baseCost != null ? !baseCost.equals(that.baseCost) : that.baseCost != null) return false;
        if (callingCost != null ? !callingCost.equals(that.callingCost) : that.callingCost != null) return false;
        if (messageCost != null ? !messageCost.equals(that.messageCost) : that.messageCost != null) return false;
        if (dataCost != null ? !dataCost.equals(that.dataCost) : that.dataCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (baseCost != null ? baseCost.hashCode() : 0);
        result = 31 * result + (callingCost != null ? callingCost.hashCode() : 0);
        result = 31 * result + (messageCost != null ? messageCost.hashCode() : 0);
        result = 31 * result + (dataCost != null ? dataCost.hashCode() : 0);
        return result;
    }
}
