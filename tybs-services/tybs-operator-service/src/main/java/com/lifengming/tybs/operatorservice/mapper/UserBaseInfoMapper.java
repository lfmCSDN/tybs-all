package com.lifengming.tybs.operatorservice.mapper;

import com.lifengming.tybs.pojo.po.UserBaseInfo;
import com.lifengming.tybs.pojo.qo.UserAndCardQo;
import com.lifengming.tybs.pojo.qo.UserBaseInfoQo;
import com.lifengming.tybs.pojo.vo.UserAndCardVo;
import com.lifengming.tybs.pojo.vo.UserBaseInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * on 2018-04-07 12:25
 * @author lifengming
 */
public interface UserBaseInfoMapper {

    UserBaseInfo getObjectByPrimarykey(String userBaseInfoid);

    UserBaseInfo getObjectByCardId(String userCardId);
    /*查询账户*/
    List<UserAndCardVo> getUserByIdCard(@Param("userAndCardQo") UserAndCardQo userAndCardQo);

    List<UserBaseInfoVo> getAcct(@Param("userBaseInfoQo") UserBaseInfoQo userBaseInfoQo);

    void modifyTelUser(@Param("userBaseInfoQo") UserBaseInfoQo userBaseInfoQo);
    /*用户基本信息*/
    void addUserBaseInfo(@Param("userAndCardVo") UserAndCardVo userAndCardVo);

}
