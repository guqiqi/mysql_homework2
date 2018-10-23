package entity;

import constant.CallingType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "calling_record", schema = "mysql_homework2")
public class CallingRecordEntity {
    private Integer id;
    private String phoneNumber;
    private CallingType type;
    private Timestamp time;
    private Integer lastingTime;
    private Double cost;

    public CallingRecordEntity(){

    }

    public CallingRecordEntity(String phoneNumber, CallingType type, Timestamp time, Integer lastingTime, Double cost){
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.time = time;
        this.lastingTime = lastingTime;
        this.cost = cost;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public CallingType getType() {
        return type;
    }

    public void setType(CallingType type) {
        this.type = type;
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
    @Column(name = "lasting_time")
    public Integer getLastingTime() {
        return lastingTime;
    }

    public void setLastingTime(Integer lastingTime) {
        this.lastingTime = lastingTime;
    }

    @Basic
    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallingRecordEntity that = (CallingRecordEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (lastingTime != null ? !lastingTime.equals(that.lastingTime) : that.lastingTime != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (lastingTime != null ? lastingTime.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
