package com.lifengming.tybs.acctservice.controller;

import com.lifengming.tybs.acctservice.service.AcctService;
import com.lifengming.tybs.pojo.qo.TransListInfoQo;
import com.lifengming.tybs.pojo.vo.CardBaseInfoVo;
import com.lifengming.tybs.pojo.vo.TransListInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2018/4/4 0004
 * @author lifengming
 */
@RestController
@RequestMapping("/acct")
public class AcctController {

    @Autowired
    AcctService acctService;

    @RequestMapping("/bankSaving")
    public String bankSaving(@RequestBody CardBaseInfoVo cardBaseInfoVo) {
        return acctService.bankSaving(cardBaseInfoVo);
    }

    @RequestMapping("/transfer")
    public String transfer(@RequestBody CardBaseInfoVo cardBaseInfoVo) {
        return acctService.transfer(cardBaseInfoVo);
    }

    @RequestMapping("/transferByMoney")
    public String transferByMoney(@RequestBody CardBaseInfoVo cardBaseInfoVo) {
        return acctService.transferByMoney(cardBaseInfoVo);
    }

    @RequestMapping("/drawMoney")
    public String drawMoney(@RequestBody CardBaseInfoVo cardBaseInfoVo) {
        return acctService.drawMoney(cardBaseInfoVo);
    }

    @RequestMapping("/getTransList")
    public List<TransListInfoVo> getTransList(@RequestBody TransListInfoQo transListInfoQo) {
        return acctService.getTransList(transListInfoQo);
    }
}
