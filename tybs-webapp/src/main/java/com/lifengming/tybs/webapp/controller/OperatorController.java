package com.lifengming.tybs.webapp.controller;

import com.lifengming.tybs.pojo.po.UserOperInfo;
import com.lifengming.tybs.pojo.qo.UserAndCardQo;
import com.lifengming.tybs.pojo.qo.UserBaseInfoQo;
import com.lifengming.tybs.pojo.qo.UserOperInfoQo;
import com.lifengming.tybs.pojo.vo.CardBaseInfoVo;
import com.lifengming.tybs.pojo.vo.TableVo;
import com.lifengming.tybs.pojo.vo.UserAndCardVo;
import com.lifengming.tybs.pojo.vo.UserBaseInfoVo;
import com.lifengming.tybs.webapp.feignclient.OperatorFeign;
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
 * on 2018-03-19 22:11 账户管理
 *
 * @author lifengming
 */

@Controller
@RequestMapping("/operator")
public class OperatorController {

    private static Logger log = LoggerFactory.getLogger( OperatorController.class );
    @Autowired
    private OperatorFeign operatorFeign;

    /**
     * 登录
     *
     * @param userOperInfoQo
     * @param model
     *
     * @return
     */
    @RequestMapping("/login")
    public String OperatorLogin(UserOperInfoQo userOperInfoQo, Model model) {
        UserOperInfo operator = operatorFeign.login( userOperInfoQo );
        String loginName = userOperInfoQo.getOperName();
        String loginTime = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new Date() );
        model.addAttribute( "loginTime", loginTime );
        model.addAttribute( "loginName", loginName );
        if (operator == null || "不正常".equals( operator.getOperStatu() )) {
            return "login";
        } else {
            return "operatorMain";
        }
    }

    /**
     * 跳转开通账户
     */
    @RequestMapping("/addUserVm")
    public String addUserVm() {
        return "addUser";
    }

    /**
     * 跳转查找账户
     *
     * @return
     */
    @RequestMapping("/queryUserVm")
    public String queryUserVm() {
        return "queryUser";
    }

    /**
     * 账户开通
     */

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorFeign.addUser( userAndCardVo );
    }

    /**
     * 注销账户
     */

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorFeign.deleteUser( userAndCardVo );
    }

    /**
     * 查询账户
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public TableVo<UserAndCardVo> getUser(UserAndCardQo userAndCardQo, Model model) {
        List<UserAndCardVo> list = operatorFeign.getUser( userAndCardQo );
        TableVo<UserAndCardVo> tableVo = new TableVo<>();
        tableVo.setCode( 0 );
        tableVo.setMsg( "success" );
        tableVo.setCount( list.size() );
        tableVo.setData( list );
        return tableVo;
    }

    @RequestMapping("/getAcct")
    @ResponseBody
    public TableVo<UserBaseInfoVo> getAcct(UserBaseInfoQo userBaseInfoQo, Model model) {
        List<UserBaseInfoVo> list = operatorFeign.getAcct( userBaseInfoQo );
        TableVo<UserBaseInfoVo> tableVo = new TableVo<>();
        tableVo.setCode( 0 );
        tableVo.setMsg( "success" );
        tableVo.setCount( list.size() );
        tableVo.setData( list );
        return tableVo;
    }

    /**
     * 跳转卡操作
     */
    @RequestMapping("/operCardVm")
    public String operCardVm() {
        return "operCard";
    }

    /**
     * 冻结账号
     */
    @RequestMapping("/freezeUser")
    @ResponseBody
    public String freezeUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorFeign.freezeUser( userAndCardVo );
    }

    /**
     * 解冻账户
     */
    @RequestMapping("/upFreezeUser")
    @ResponseBody
    public String upFreezeUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorFeign.upFreezeUser( userAndCardVo );

    }

    /**
     * 挂失账户
     */
    @RequestMapping("/lostUser")
    @ResponseBody
    public String lostUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorFeign.lostUser( userAndCardVo );
    }

    /**
     * 解挂账户
     */
    @RequestMapping("/upLostUser")
    @ResponseBody
    public String upLostUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorFeign.upLostUser( userAndCardVo );
    }

    /**
     * 跳转修改密码
     */
    @RequestMapping("/toModifyPwd")
    public String toModifyPwd() {
        return "modifyPwd";
    }

    /**
     * 修改密码
     */
    @RequestMapping("/modifyPwd")
    @ResponseBody
    public String modifyPwd(CardBaseInfoVo cardBaseInfoVo, Model model) {
        return operatorFeign.modifyPwd( cardBaseInfoVo );
    }

    /**
     * 跳转密码重置页面
     */
    @RequestMapping("/jumpInputPwd")
    public String jumpInputPwd() {
        return "jumpInputPwd";
    }

    /**
     * 跳转重置密码
     */
    @RequestMapping("/toResetPwd")
    public String toResetPwd() {
        return "resetPwd";
    }

    /**
     * 重置密码
     */
    @RequestMapping("/resetPwd")
    @ResponseBody
    public String resetPwd(CardBaseInfoVo cardBaseInfoVo, Model model) {
        return operatorFeign.resetPwd( cardBaseInfoVo );
    }

    /**
     * 跳转修改手机号
     */
    @RequestMapping("/toModifyUser")
    public String toModifyUser() {
        return "modifyUser";
    }

    /**
     * 修改账户
     */
    @RequestMapping("/modifyUser")
    @ResponseBody
    public String modifyUser(UserBaseInfoQo userBaseInfoQo, Model model) {
        return operatorFeign.modifyUser( userBaseInfoQo );
    }

    /**
     * 退出
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session, SessionStatus sessionStatus) {
        log.info( "退出......" );
        session.removeAttribute( "useroper" );
        sessionStatus.setComplete();
        return "redirect:login";
    }

}


