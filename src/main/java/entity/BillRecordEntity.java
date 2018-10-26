package entity;

import util.DateUtil;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bill_record", schema = "mysql_homework2")
public class BillRecordEntity {
    private Integer id;
    private String phoneNumber;
    private Date time;
    private Double cost;
    private Double baseCost;
    private Double callingCost;
    private Double messageCost;
    private Double dataCost;

    public BillRecordEntity() {

    }

    public BillRecordEntity(String phoneNumber, Date time, Double cost, Double baseCost, Double callingCost, Double
            messageCost, Double dataCost) {
        this.phoneNumber = phoneNumber;
        this.time = time;
        this.cost = cost;
        this.baseCost = baseCost;
        this.callingCost = callingCost;
        this.messageCost = messageCost;
        this.dataCost = dataCost;
    }

    public BillRecordEntity(String phoneNumber, Double baseCost, Double callingCost, Double
            messageCost, Double dataCost) {
        this.phoneNumber = phoneNumber;
        this.time = new Date(2018, 9, 10);
        this.cost = baseCost + callingCost + messageCost + dataCost;
        this.baseCost = baseCost;
        this.callingCost = callingCost;
        this.messageCost = messageCost;
        this.dataCost = dataCost;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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

        BillRecordEntity that = (BillRecordEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (baseCost != null ? !baseCost.equals(that.baseCost) : that.baseCost != null) return false;
        if (callingCost != null ? !callingCost.equals(that.callingCost) : that.callingCost != null) return false;
        if (messageCost != null ? !messageCost.equals(that.messageCost) : that.messageCost != null) return false;
        if (dataCost != null ? !dataCost.equals(that.dataCost) : that.dataCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (baseCost != null ? baseCost.hashCode() : 0);
        result = 31 * result + (callingCost != null ? callingCost.hashCode() : 0);
        result = 31 * result + (messageCost != null ? messageCost.hashCode() : 0);
        result = 31 * result + (dataCost != null ? dataCost.hashCode() : 0);
        return result;
    }
}
