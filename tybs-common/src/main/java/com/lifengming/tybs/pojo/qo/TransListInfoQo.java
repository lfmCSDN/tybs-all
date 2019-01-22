package com.lifengming.tybs.pojo.qo;


/**
 * Date:2018-03-30
 * @author lifengming
 */
public class TransListInfoQo {
    private String cardBaseInfoId;
    private String userBaseInfoId;
    private String transId;
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getCardBaseInfoId() {
        return cardBaseInfoId;
    }

    public void setCardBaseInfoId(String cardBaseInfoId) {
        this.cardBaseInfoId = cardBaseInfoId;
    }

    public String getTransId() {
        return transId;
    }

    public String getUserBaseInfoId() {
        return userBaseInfoId;
    }

    public void setUserBaseInfoId(String userBaseInfoId) {
        this.userBaseInfoId = userBaseInfoId;
    }
}
