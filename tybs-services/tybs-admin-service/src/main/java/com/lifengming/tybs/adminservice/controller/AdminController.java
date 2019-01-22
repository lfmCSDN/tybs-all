package com.lifengming.tybs.adminservice.controller;

import com.lifengming.tybs.adminservice.service.AdminService;
import com.lifengming.tybs.pojo.po.UserAdminInfo;
import com.lifengming.tybs.pojo.qo.UserAdminInfoQo;
import com.lifengming.tybs.pojo.qo.UserOperInfoQo;
import com.lifengming.tybs.pojo.vo.UserOperInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lifengming
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public UserAdminInfo login(@RequestBody UserAdminInfoQo adm) {
        String name = adm.getAdminName();
        String password = adm.getAdminPwd();
        UserAdminInfo admin = adminService.login( name, password );
        return admin;
    }

    /**
     * 添加操作员
     */
    @RequestMapping("/addOperator")
    public String addOperator(@RequestBody UserOperInfoVo userOperInfoVo) {
        return adminService.addOperator( userOperInfoVo );
    }

    /**
     * 删除操作员
     */
    @RequestMapping("/deleteOperator")
    public String deleteOperator(@RequestBody UserOperInfoQo userOperInfoQo) {
        return adminService.deleteOperator( userOperInfoQo );
    }

    /**
     * 查询操作员
     */
    @RequestMapping("/getOperator")
    public List<UserOperInfoVo> getOperator(@RequestBody UserOperInfoQo userOperInfoQo) {
        return adminService.getOperator( userOperInfoQo );
    }

    /**
     * 修改操作员
     */
    @RequestMapping("/updateOperator")
    public String updateOperator(@RequestBody UserOperInfoVo userOperInfoVo) {
        return adminService.updateOperator( userOperInfoVo );
    }
}
