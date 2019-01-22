package com.lifengming.tybs.operatorservice.controller;

import com.lifengming.tybs.operatorservice.service.OperatorService;
import com.lifengming.tybs.pojo.po.UserOperInfo;
import com.lifengming.tybs.pojo.qo.UserAndCardQo;
import com.lifengming.tybs.pojo.qo.UserBaseInfoQo;
import com.lifengming.tybs.pojo.qo.UserOperInfoQo;
import com.lifengming.tybs.pojo.vo.CardBaseInfoVo;
import com.lifengming.tybs.pojo.vo.UserAndCardVo;
import com.lifengming.tybs.pojo.vo.UserBaseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by Lfm
 * on 2018-04-06 10:59
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    private OperatorService operatorService;

    //操作员登录
    @RequestMapping("/login")
    public UserOperInfo login(@RequestBody UserOperInfoQo oper) {
        String name = oper.getOperName();
        String password = oper.getLoginPwd();
        UserOperInfo operator = operatorService.login(name, password);
        return operator;
    }

    //账户开通
    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserAndCardVo userAndCardVo) {
        return operatorService.addUser(userAndCardVo);
    }

    //注销账户
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestBody UserAndCardVo userAndCardVo) {
        return operatorService.deleteUser(userAndCardVo);
    }

    // 查询账户
    @RequestMapping("/getUser")
    public List<UserAndCardVo> getUser(@RequestBody UserAndCardQo userAndCardQo) {
        return operatorService.getUser(userAndCardQo);
    }

    //获取User的对象
    @RequestMapping("/getAcct")
    public List<UserBaseInfoVo> getAcct(@RequestBody UserBaseInfoQo userBaseInfoQo) {
        return operatorService.getAcct(userBaseInfoQo);
    }

    // 冻结账户
    @RequestMapping("/freezeUser")
    public String freezeUser(@RequestBody UserAndCardVo userAndCardVo) {
        return operatorService.freezeUser(userAndCardVo);
    }

    //挂失账户
    @RequestMapping("/lostUser")
    public String lostUser(@RequestBody UserAndCardVo userAndCardVo) {
        return operatorService.lostUser(userAndCardVo);
    }

    //解挂账户
    @RequestMapping("/upLostUser")
    public String upLostUser(@RequestBody UserAndCardVo userAndCardVo) {
        return operatorService.upLostUser(userAndCardVo);
    }

    //解冻账户
    @RequestMapping("/upFreezeUser")
    public String upFreezeUser(@RequestBody UserAndCardVo userAndCardVo) {
        return operatorService.upFreezeUser(userAndCardVo);
    }

    //修改密码
    @RequestMapping("/modifyPwd")
    public String modifyPwd(@RequestBody CardBaseInfoVo cardBaseInfoVo) {
        return operatorService.modifyPwd(cardBaseInfoVo);
    }

    //重置密码
    @RequestMapping("/resetPwd")
    public String resetPwd(@RequestBody CardBaseInfoVo cardBaseInfoVo) {
        return operatorService.resetPwd(cardBaseInfoVo);
    }

    //修改账户
    @RequestMapping("/modifyUser")
    public String modifyUser(@RequestBody UserBaseInfoQo userBaseInfoQo) {
        return operatorService.modifyUser(userBaseInfoQo);
    }
}
