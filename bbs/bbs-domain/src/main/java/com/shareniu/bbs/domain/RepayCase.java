package com.shareniu.bbs.domain;

import java.util.Date;

public class RepayCase {
    private Integer id;

    private Integer caseId;

    private Integer orderId;

    private Integer capital;

    private Integer repayState;

    private Integer businessArea;

    private String customerName;

    private Integer customerType;

    private Integer phoneNumber;

    private Integer aging;

    private Integer lateDays;

    private Integer todayTotalAmount;

    private Integer productLine;

    private Integer productType;

    private Integer iouAmount;

    private Integer sysuserId;

    private Date lastUpdateTime;

    private Integer caseStatus;

    private Integer flowStatus;

    private Integer reminder;

    private Integer repayCompany;
    


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public Integer getRepayState() {
        return repayState;
    }

    public void setRepayState(Integer repayState) {
        this.repayState = repayState;
    }

    public Integer getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(Integer businessArea) {
        this.businessArea = businessArea;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAging() {
        return aging;
    }

    public void setAging(Integer aging) {
        this.aging = aging;
    }

    public Integer getLateDays() {
        return lateDays;
    }

    public void setLateDays(Integer lateDays) {
        this.lateDays = lateDays;
    }

    public Integer getTodayTotalAmount() {
        return todayTotalAmount;
    }

    public void setTodayTotalAmount(Integer todayTotalAmount) {
        this.todayTotalAmount = todayTotalAmount;
    }

    public Integer getProductLine() {
        return productLine;
    }

    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getIouAmount() {
        return iouAmount;
    }

    public void setIouAmount(Integer iouAmount) {
        this.iouAmount = iouAmount;
    }

    public Integer getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(Integer sysuserId) {
        this.sysuserId = sysuserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(Integer caseStatus) {
        this.caseStatus = caseStatus;
    }

    public Integer getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(Integer flowStatus) {
        this.flowStatus = flowStatus;
    }

    public Integer getReminder() {
        return reminder;
    }

    public void setReminder(Integer reminder) {
        this.reminder = reminder;
    }

    public Integer getRepayCompany() {
        return repayCompany;
    }

    public void setRepayCompany(Integer repayCompany) {
        this.repayCompany = repayCompany;
    }
}