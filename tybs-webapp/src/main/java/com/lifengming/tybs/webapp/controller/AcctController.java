package com.lifengming.tybs.webapp.controller;

import com.lifengming.tybs.pojo.qo.TransListInfoQo;
import com.lifengming.tybs.pojo.vo.CardBaseInfoVo;
import com.lifengming.tybs.pojo.vo.TableVo;
import com.lifengming.tybs.pojo.vo.TransListInfoVo;
import com.lifengming.tybs.webapp.feignclient.AcctFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * on 2018-03-24 14:32
 * @author lifengming
 */
@Controller
@RequestMapping("/acct")
public class AcctController {

    @Autowired
    private AcctFeign acctFeign;

    /**
     * 存款
     */
    @RequestMapping("/toBankSaving")
    public String toBankSaving() {
        return "bankSaving";
    }

    /**
     * 取款
     */
    @RequestMapping("/toDrawMoney")
    public String toDrawMoney() {
        return "drawMoney";
    }

    /**
     * 转账
     */
    @RequestMapping("/toTransfer")
    public String toTransfer() {
        return "transfer";
    }

    /**
     * 转账
     */
    @RequestMapping("/toTransferByMoney")
    public String toTransferByMoney() {
        return "transferByMoney";
    }

    /**
     * 交易明细
     */
    @RequestMapping("/toTransList")
    public String toTransList() {
        return "transList";
    }

    @RequestMapping("/bankSaving")
    @ResponseBody
    public String bankSaving(CardBaseInfoVo cardBaseInfoVo) {
        return acctFeign.bankSaving( cardBaseInfoVo );
    }

    @RequestMapping("/drawMoney")
    @ResponseBody
    public String drawMoney(CardBaseInfoVo cardBaseInfoVo) {
        return acctFeign.drawMoney( cardBaseInfoVo );
    }

    @RequestMapping("/transfer")
    @ResponseBody
    public String transfer(CardBaseInfoVo cardBaseInfoVo) {
        return acctFeign.transfer( cardBaseInfoVo );
    }

    @RequestMapping("/transferByMoney")
    @ResponseBody
    public String transferByMoney(CardBaseInfoVo cardBaseInfoVo) {
        return acctFeign.transferByMoney( cardBaseInfoVo );
    }

    @RequestMapping("/getTransList")
    @ResponseBody
    public TableVo<TransListInfoVo> getTransList(TransListInfoQo transListInfoQo, Model model) {
        List<TransListInfoVo> list = acctFeign.getTransList( transListInfoQo );
        TableVo<TransListInfoVo> tableVo = new TableVo<>();
        tableVo.setCode( 0 );
        tableVo.setMsg( "success" );
        tableVo.setCount( list.size() );
        tableVo.setData( list );
        return tableVo;
    }

}
