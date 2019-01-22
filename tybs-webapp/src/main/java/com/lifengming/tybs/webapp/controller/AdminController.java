package com.lifengming.tybs.webapp.controller;

import com.lifengming.tybs.pojo.po.UserOperInfo;
import com.lifengming.tybs.pojo.qo.UserAdminInfoQo;
import com.lifengming.tybs.pojo.qo.UserOperInfoQo;
import com.lifengming.tybs.pojo.vo.TableVo;
import com.lifengming.tybs.pojo.vo.UserOperInfoVo;
import com.lifengming.tybs.webapp.feignclient.AdminFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * on 2018-03-18 12:06
 * @author lifengming
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static Logger log = LoggerFactory.getLogger( AdminController.class );
    @Autowired
    private AdminFeign adminFeign;

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String adminLogin(UserAdminInfoQo userAdminInfoQo, Model model) {
        UserOperInfo user = adminFeign.login( userAdminInfoQo );
        String loginName = userAdminInfoQo.getAdminName();
        String loginTime = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new Date() );
        model.addAttribute( "loginTime", loginTime );
        model.addAttribute( "loginName", loginName );
        if (user == null) {
            return "login";
        } else {
            return "adminMain";
        }
    }

    /**
     * 退出
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session, SessionStatus sessionStatus) {
        log.info( "退出......" );
        session.removeAttribute( "user" );
        sessionStatus.setComplete();
        return "redirect:login";
    }

    /**
     * 跳转添加操作员页面
     */
    @RequestMapping("/addOperatorVm")
    public String addOperatorVm() {
        return "addOperator";
    }

    /**
     * 跳转查询操作员页面
     */
    @RequestMapping("/queryOperatorVm")
    public String queryOperatorVm() {
        return "queryOperator";
    }

    /**
     * 添加操作员
     */
    @RequestMapping("/addOperator")
    @ResponseBody
    public String addOperator(UserOperInfoVo userOperInfoVo, Model model) {
        return adminFeign.addOperator( userOperInfoVo );
    }

    /**
     * 删除操作员
     */
    @RequestMapping("/deleteOperator")
    @ResponseBody
    public String deleteOperator(UserOperInfoQo userOperInfoQo, Model model) {
        return adminFeign.deleteOperator( userOperInfoQo );

    }

    /**
     * 修改操作员
     */
    @RequestMapping("/updateOperator")
    @ResponseBody
    public String updateOperator(UserOperInfoVo userOperInfoVo, Model model) {
        return adminFeign.updateOperator( userOperInfoVo );
    }

    /**
     * 查询操作员
     */
    @RequestMapping("/getOperator")
    @ResponseBody
    public TableVo<UserOperInfoVo> getOperator(UserOperInfoQo userOperInfoQo, Model model) {
        List<UserOperInfoVo> list = adminFeign.getOperator( userOperInfoQo );
        TableVo<UserOperInfoVo> tableVo = new TableVo<>();
        tableVo.setCode( 0 );
        tableVo.setMsg( "success" );
        tableVo.setCount( list.size() );
        tableVo.setData( list );
        return tableVo;
    }

}
