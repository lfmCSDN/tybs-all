package com.lifengming.tybs.adminservice.service;

import com.lifengming.tybs.pojo.po.UserAdminInfo;
import com.lifengming.tybs.pojo.qo.UserOperInfoQo;
import com.lifengming.tybs.pojo.vo.UserOperInfoVo;

import java.util.List;

/**
 * on 2018-03-18 12:04
 * @author lifengming
 */
public interface AdminService {
    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    UserAdminInfo login(String username, String password);

    /**
     * 增加操作员
     * @param userOperInfoVo
     * @return
     */
    String addOperator(UserOperInfoVo userOperInfoVo);

    /**
     * 查询操作员
     * @param userOperInfoQo
     * @return
     */
    List<UserOperInfoVo> getOperator(UserOperInfoQo userOperInfoQo);

    /**
     * 删除操作员
     * @param userOperInfoQo
     * @return
     */
    String deleteOperator(UserOperInfoQo userOperInfoQo);

    /**
     * 修改操作员
     * @param userOperInfoVo
     * @return
     */
    String updateOperator(UserOperInfoVo userOperInfoVo);
}
