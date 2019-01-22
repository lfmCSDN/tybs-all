package com.lifengming.tybs.pojo.po;

import java.math.BigDecimal;

/**
 * User:honc.z
 * Date:2018-03-30
 */
public class TransListInfo {
    private String transListInfoId;
    private String cardBaseInfoId;
    private String userBaseInfoId;
    private String serialNumber;
    private String transName;
    private String transId;
    private String transType;
    private BigDecimal transAmount;
    private String transTime;

    public TransListInfo() {
    }

    public TransListInfo(String transListInfoId, String cardBaseInfoId, String userBaseInfoId, String serialNumber, String transName, String transId, String transType, BigDecimal transAmount, String transTime) {
        this.transListInfoId = transListInfoId;
        this.cardBaseInfoId = cardBaseInfoId;
        this.userBaseInfoId=userBaseInfoId;
        this.serialNumber = serialNumber;
        this.transName = transName;
        this.transId = transId;
        this.transType = transType;
        this.transAmount = transAmount;
        this.transTime = transTime;

    }

    public String getTransListInfoId() {
        return transListInfoId;
    }

    public void setTransListInfoId(String transListInfoId) {
        this.transListInfoId = transListInfoId;
    }

    public String getCardBaseInfoId() {
        return cardBaseInfoId;
    }

    public void setCardBaseInfoId(String cardBaseInfoId) {
        this.cardBaseInfoId = cardBaseInfoId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }
    public String getUserBaseInfoId() {
        return userBaseInfoId;
    }

    public void setUserBaseInfoId(String userBaseInfoId) {
        this.userBaseInfoId = userBaseInfoId;
    }
}
