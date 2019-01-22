package com.lifengming.tybs.acctservice.mapper;

import com.lifengming.tybs.pojo.po.UserBaseInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Date:2018/4/4 0004
 * @author lifengming
 */
public interface UserBaseInfoMapper {

    UserBaseInfo getObjectByPrimarykey(@Param("userBaseInfoId") String userBaseInfoId);
}
