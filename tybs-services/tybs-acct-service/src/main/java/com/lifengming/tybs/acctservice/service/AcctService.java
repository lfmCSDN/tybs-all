package com.lifengming.tybs.acctservice.service;

import com.lifengming.tybs.pojo.qo.TransListInfoQo;
import com.lifengming.tybs.pojo.vo.CardBaseInfoVo;
import com.lifengming.tybs.pojo.vo.TransListInfoVo;

import java.util.List;

/**
 * Date:2018/4/4 0004
 * @author lifengming
 */
public interface AcctService {

    List<TransListInfoVo> getTransList(TransListInfoQo transListInfoQo);

    String bankSaving(CardBaseInfoVo cardBaseInfoVo);

    String transfer(CardBaseInfoVo cardBaseInfoVo);

    String drawMoney(CardBaseInfoVo cardBaseInfoVo);

    String transferByMoney(CardBaseInfoVo cardBaseInfoVo);
}
