package com.lifengming.tybs.pojo.vo;

import java.math.BigDecimal;

/**
 * Date:2018-03-30
 * @author lifengming
 */
public class TransListInfoVo {
    private String transListInfoId;
    private String cardBaseInfoId;
    private String userBaseInfoId;
    private String serialNumber;
    private String transName;
    private String transId;
    private String transType;
    private BigDecimal transAmount;
    private String transTime;
    private String transCardType;

    public void setTransCardType(String transCardType) {
        this.transCardType = transCardType;
    }

    public String getCardBaseInfoId() {
        return cardBaseInfoId;
    }

    public void setCardBaseInfoId(String cardBaseInfoId) {
        this.cardBaseInfoId = cardBaseInfoId;
    }

    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public void setTransName(String transName) { this.transName = transName; }

    public void setTransId(String transId) { this.transId = transId; }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
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
