package entity;

import javax.persistence.*;

@Entity
@Table(name = "real_time_record", schema = "mysql_homework2", catalog = "")
public class RealTimeRecordEntity {
    private String phoneNumber;
    private Double baseCost;
    private Double callingCost;
    private Double messageCost;
    private Double dataCost;
    private Integer calling;
    private Integer message;
    private Integer localData;
    private Integer nationalData;
    private Integer baseMessage;
    private Integer baseLocalData;
    private Integer baseNationalData;
    private Integer baseCalling;

    public RealTimeRecordEntity() {
    }

    public RealTimeRecordEntity(String phoneNumber, Double baseCost, Double callingCost, Double messageCost, Double dataCost, Integer calling, Integer message, Integer localData, Integer nationalData, Integer baseCalling, Integer baseMessage, Integer baseLocalData, Integer baseNationalData) {
        this.phoneNumber = phoneNumber;
        this.baseCost = baseCost;
        this.callingCost = callingCost;
        this.messageCost = messageCost;
        this.dataCost = dataCost;
        this.calling = calling;
        this.message = message;
        this.localData = localData;
        this.nationalData = nationalData;
        this.baseCalling = baseCalling;
        this.baseMessage = baseMessage;
        this.baseLocalData = baseLocalData;
        this.baseNationalData = baseNationalData;
    }

    public RealTimeRecordEntity(String phoneNumber, Double baseCost, Integer baseCalling, Integer baseMessage, Integer baseLocalData, Integer baseNationalData) {
        this.phoneNumber = phoneNumber;
        this.baseCost = baseCost;
        this.callingCost = 0.0;
        this.messageCost = 0.0;
        this.dataCost = 0.0;
        this.calling = 0;
        this.message = 0;
        this.localData = 0;
        this.nationalData = 0;
        this.baseCalling = baseCalling;
        this.baseMessage = baseMessage;
        this.baseLocalData = baseLocalData;
        this.baseNationalData = baseNationalData;
    }

    public RealTimeRecordEntity(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.baseCost = 0.0;
        this.callingCost = 0.0;
        this.messageCost = 0.0;
        this.dataCost = 0.0;
        this.calling = 0;
        this.message = 0;
        this.localData = 0;
        this.nationalData = 0;
        this.baseCalling = 0;
        this.baseMessage = 0;
        this.baseLocalData = 0;
        this.baseNationalData = 0;
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
    @Column(name = "local_data")
    public Integer getLocalData() {
        return localData;
    }

    public void setLocalData(Integer localData) {
        this.localData = localData;
    }

    @Basic
    @Column(name = "national_data")
    public Integer getNationalData() {
        return nationalData;
    }

    public void setNationalData(Integer nationalData) {
        this.nationalData = nationalData;
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
    @Column(name = "base_local_data")
    public Integer getBaseLocalData() {
        return baseLocalData;
    }

    public void setBaseLocalData(Integer baseLocalData) {
        this.baseLocalData = baseLocalData;
    }

    @Basic
    @Column(name = "base_national_data")
    public Integer getBaseNationalData() {
        return baseNationalData;
    }

    public void setBaseNationalData(Integer baseNationalData) {
        this.baseNationalData = baseNationalData;
    }

    @Basic
    @Column(name = "base_calling")
    public Integer getBaseCalling() {
        return baseCalling;
    }

    public void setBaseCalling(Integer baseCalling) {
        this.baseCalling = baseCalling;
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
        if (calling != null ? !calling.equals(that.calling) : that.calling != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (localData != null ? !localData.equals(that.localData) : that.localData != null) return false;
        if (nationalData != null ? !nationalData.equals(that.nationalData) : that.nationalData != null) return false;
        if (baseMessage != null ? !baseMessage.equals(that.baseMessage) : that.baseMessage != null) return false;
        if (baseLocalData != null ? !baseLocalData.equals(that.baseLocalData) : that.baseLocalData != null)
            return false;
        if (baseNationalData != null ? !baseNationalData.equals(that.baseNationalData) : that.baseNationalData != null)
            return false;
        if (baseCalling != null ? !baseCalling.equals(that.baseCalling) : that.baseCalling != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (baseCost != null ? baseCost.hashCode() : 0);
        result = 31 * result + (callingCost != null ? callingCost.hashCode() : 0);
        result = 31 * result + (messageCost != null ? messageCost.hashCode() : 0);
        result = 31 * result + (dataCost != null ? dataCost.hashCode() : 0);
        result = 31 * result + (calling != null ? calling.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (localData != null ? localData.hashCode() : 0);
        result = 31 * result + (nationalData != null ? nationalData.hashCode() : 0);
        result = 31 * result + (baseMessage != null ? baseMessage.hashCode() : 0);
        result = 31 * result + (baseLocalData != null ? baseLocalData.hashCode() : 0);
        result = 31 * result + (baseNationalData != null ? baseNationalData.hashCode() : 0);
        result = 31 * result + (baseCalling != null ? baseCalling.hashCode() : 0);
        return result;
    }
}
