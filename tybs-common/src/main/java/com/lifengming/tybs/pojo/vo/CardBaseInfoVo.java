package com.lifengming.tybs.pojo.vo;

import java.math.BigDecimal;

/**
 * Date:2018-03-30
 * @author lifengming
 */
public class CardBaseInfoVo {
    private String cardBaseInfoId;
    private String cardId;
    private String transPwd;
    private String cardType;
    private String transPwd1;
    private String transPwd2;
    private BigDecimal amount;
    private String payCardId;
    private String receiptName;
    private String receiptCardId;

    public String getCardBaseInfoId() {
        return cardBaseInfoId;
    }

    public void setCardBaseInfoId(String cardBaseInfoId) {
        this.cardBaseInfoId = cardBaseInfoId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTransPwd() {
        return transPwd;
    }

    public void setTransPwd(String transPwd) {
        this.transPwd = transPwd;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getTransPwd1() {
        return transPwd1;
    }

    public void setTransPwd1(String transPwd1) {
        this.transPwd1 = transPwd1;
    }

    public String getTransPwd2() {
        return transPwd2;
    }

    public void setTransPwd2(String transPwd2) {
        this.transPwd2 = transPwd2;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getPayCardId() {
        return payCardId;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public String getReceiptCardId() {
        return receiptCardId;
    }

}
