package com.lifengming.tybs.operatorservice.mapper;

import com.lifengming.tybs.pojo.po.UserOperInfo;
import org.apache.ibatis.annotations.Param;

/**
 * on 2018-04-06 11:00
 * @author lifengming
 */
public interface OperatorMapper {
    UserOperInfo getOperator(@Param("operName") String operName, @Param("loginPwd") String loginPwd);
}
