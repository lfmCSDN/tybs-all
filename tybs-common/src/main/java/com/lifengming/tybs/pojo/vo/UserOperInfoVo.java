package com.lifengming.tybs.pojo.vo;

/**
 * Date:2018-03-29
 * @author lifengming
 */
public class UserOperInfoVo {
    private String userOperInfoId;
    private String loginPwd;
    private String operName;
    private String operCardId;


    public String getUserOperInfoId() {
        return userOperInfoId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperCardId() {
        return operCardId;
    }

}
