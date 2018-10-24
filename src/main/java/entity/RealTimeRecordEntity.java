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
    private Integer calling;
    private Integer message;
    private Integer data;
    private Integer baseCalling;
    private Integer baseMessage;
    private Integer baseData;

    public RealTimeRecordEntity() {
    }

    public RealTimeRecordEntity(String phoneNumber, Double baseCost, Double callingCost, Double messageCost, Double dataCost, Integer calling, Integer message, Integer data, Integer baseCalling, Integer baseMessage, Integer baseData) {
        this.phoneNumber = phoneNumber;
        this.baseCost = baseCost;
        this.callingCost = callingCost;
        this.messageCost = messageCost;
        this.dataCost = dataCost;
        this.calling = calling;
        this.message = message;
        this.data = data;
        this.baseCalling = baseCalling;
        this.baseMessage = baseMessage;
        this.baseData = baseData;
    }

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

    @Basic
    @Column(name = "calling")
    public Integer getCalling() {
        return calling;
    }

    public void setCalling(Integer calling) {
        this.calling = calling;
    }

    @Basic
    @Column(name = "message")
    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    @Basic
    @Column(name = "data")
    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
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
    @Column(name = "base_data")
    public Integer getBaseData() {
        return baseData;
    }

    public void setBaseData(Integer baseData) {
        this.baseData = baseData;
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
