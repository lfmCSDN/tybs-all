package com.lifengming.tybs.adminservice.mapper;


import com.lifengming.tybs.pojo.po.UserAdminInfo;
import com.lifengming.tybs.pojo.po.UserOperInfo;
import com.lifengming.tybs.pojo.qo.UserOperInfoQo;
import com.lifengming.tybs.pojo.vo.UserOperInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * on 2018-03-18 12:00
 * @author lifengming
 */

public interface AdminMapper {

    UserAdminInfo getUser(@Param("adminName") String adminName, @Param("adminPwd") String adminPwd);

    UserOperInfo getObjectByIdCard(@Param("operCardId") String operCardId);

    UserOperInfo getObjectByPrimarykey(@Param("userOperInfoId") String userOperInfoId);

    UserOperInfo getObjectByName(@Param("operName") String operName);

    List<UserOperInfoVo> getOperator(@Param("userOperInfoQo") UserOperInfoQo userOperInfoQo);

    void deleteOperator(@Param("userOperInfoId") String userOperInfoId);

    void updateOperator(@Param("userOperInfoVo") UserOperInfoVo userOperInfoVo);

    void addOperator(@Param("userOperInfoVo") UserOperInfoVo userOperInfoVo);


}
