package com.lifengming.tybs.acctservice.service.impl;

import com.lifengming.tybs.acctservice.mapper.CardBaseInfoMapper;
import com.lifengming.tybs.acctservice.mapper.TransListMapper;
import com.lifengming.tybs.acctservice.mapper.UserBaseInfoMapper;
import com.lifengming.tybs.acctservice.service.AcctService;
import com.lifengming.tybs.pojo.po.CardBaseInfo;
import com.lifengming.tybs.pojo.po.TransListInfo;
import com.lifengming.tybs.pojo.po.UserBaseInfo;
import com.lifengming.tybs.pojo.qo.TransListInfoQo;
import com.lifengming.tybs.pojo.utils.DateUtils;
import com.lifengming.tybs.pojo.utils.Md5Util;
import com.lifengming.tybs.pojo.vo.CardBaseInfoVo;
import com.lifengming.tybs.pojo.vo.TransListInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Date:2018/4/4 0004
 * @author lifengming
 */
@Service
@Transactional
public class AcctServiceImpl implements AcctService {

    @Autowired
    private CardBaseInfoMapper cardBaseInfoMapper;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Autowired
    private TransListMapper transListMapper;

    /*存款*/
    @Override
    public String bankSaving(CardBaseInfoVo cardBaseInfoVo) {
        CardBaseInfo cardBaseInfo;
        cardBaseInfo = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getCardId());
        if (cardBaseInfo == null) {
            return "银行卡号错误";
        }
        switch (cardBaseInfo.getStat()) {
            case "挂失":
                return "存款失败，该银行卡处于挂失状态";
            case "注销":
                return "存款失败，该银行卡已注销";
            case "冻结":
                return "存款失败，该银行卡处于冻结状态";
        }
        cardBaseInfoMapper.receipt(cardBaseInfoVo.getCardId(), cardBaseInfoVo.getAmount());

        /*添加存款交易明细*/
        String transListInfoId = UUID.randomUUID().toString();
        String serialNumber = DateUtils.getOrderOID();
        String merchandiseDate = DateUtils.dataToStr1(new Date());
        transListMapper.addTransList(transListInfoId, cardBaseInfo.getCardBaseInfoId(), serialNumber, cardBaseInfoVo.getAmount(), "存款", merchandiseDate);

        return "存款成功";
    }

    /*转账*/
    @Override
    public String transfer(CardBaseInfoVo cardBaseInfoVo) {
        String pwd = null;
        UserBaseInfo receiptMan = null;
        CardBaseInfo payCard = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getPayCardId());
        if (payCard == null) {
            return "付款账号不存在，请重新输入";
        } else if (!payCard.getCardType().equals("借记卡")) {
            return "付款账号的类型为：" + payCard.getCardType() + "，该类型卡，不能进行转账操作！";
        }
        CardBaseInfo receiptCard = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getReceiptCardId());
        if (receiptCard == null) {
            return "收款账号不存在，请重新输入";
        } else if (!receiptCard.getCardType().equals("借记卡")) {
            return "收款账号的类型为：" + receiptCard.getCardType() + "，该类型卡，不能进行转账操作！";
        } else {
            receiptMan = userBaseInfoMapper.getObjectByPrimarykey(receiptCard.getUserBaseInfoId());
            if (!cardBaseInfoVo.getReceiptName().equals(receiptMan.getUserName()))
                return "收款账号与收款人不匹配，请再次确认";
        }
        try {
            pwd = Md5Util.encodeByMd5(cardBaseInfoVo.getTransPwd());
            cardBaseInfoVo.setTransPwd(pwd);
            if (!cardBaseInfoVo.getTransPwd().equals(payCard.getTransPwd())) {
                return "转账失败,银行卡密码错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (payCard.getStat()) {
            case "挂失":
                return "转账失败，付款账号处于挂失状态";
            case "注销":
                return "转账失败，付款账号已注销";
            case "冻结":
                return "转账失败，付款账号处于冻结状态";
        }

        switch (receiptCard.getStat()) {
            case "挂失":
                return "转账失败，收款账号处于挂失状态";
            case "注销":
                return "转账失败，收款账号已注销";
            case "冻结":
                return "转账失败，收款账号处于冻结状态";
        }

        if (payCard.getOveage().compareTo(cardBaseInfoVo.getAmount()) == -1) {
            return "付款账号余额不足";
        }

        cardBaseInfoMapper.payment(payCard.getCardId(), cardBaseInfoVo.getAmount());
        cardBaseInfoMapper.receipt(receiptCard.getCardId(), cardBaseInfoVo.getAmount());

        /*添加转账明细*/
        String transListInfoId = UUID.randomUUID().toString();
        String serialNumber = DateUtils.getOrderOID();
        String merchandiseDate = DateUtils.dataToStr1(new Date());
        transListMapper.addTransList(transListInfoId, payCard.getCardBaseInfoId(), serialNumber, cardBaseInfoVo.getAmount(), "转账", merchandiseDate);
        String transListInfoId1 = UUID.randomUUID().toString();
        String serialNumber1 = DateUtils.getOrderOID();
        transListMapper.addTransList(transListInfoId1, receiptCard.getCardBaseInfoId(), serialNumber1, cardBaseInfoVo.getAmount(), "收款", merchandiseDate);

        return "转账成功";
    }

    /*取款*/
    @Override
    public String drawMoney(CardBaseInfoVo cardBaseInfoVo) {
        String pwd = null;
        CardBaseInfo payCard = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getCardId());
        if (payCard == null) {
            return "银行卡号不存在，请重新输入";
        } else if (!payCard.getCardType().equals("借记卡")) {
            return "取款账号的类型为：" + payCard.getCardType() + "，该类型卡，不能进行取款操作！";
        }
        try {
            pwd = Md5Util.encodeByMd5(cardBaseInfoVo.getTransPwd());
            cardBaseInfoVo.setTransPwd(pwd);
            if (!cardBaseInfoVo.getTransPwd().equals(payCard.getTransPwd())) {
                return "银行卡密码错误，请重新输入！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (payCard.getStat()) {
            case "挂失":
                return "取款失败，付款账号处于挂失状态";
            case "注销":
                return "取款失败，付款账号已注销";
            case "冻结":
                return "取款失败，付款账号处于冻结状态";
        }

        if (payCard.getOveage().compareTo(cardBaseInfoVo.getAmount()) == -1) {
            return "账号余额不足,不能取款！";
        }

        cardBaseInfoMapper.payment(payCard.getCardId(), cardBaseInfoVo.getAmount());

        /*添加银行卡取款交易明细*/
        String merchandiseDate = DateUtils.dataToStr1(new Date());
        String transListInfoId = UUID.randomUUID().toString();
        String serialNumber = DateUtils.getOrderOID();
        transListMapper.addTransList(transListInfoId, payCard.getCardBaseInfoId(), serialNumber, cardBaseInfoVo.getAmount(), "取款", merchandiseDate);

        return "取款成功";
    }

    /**
     * 交易明细查询
     * 1、根据TransListInfoQo查询出唯一的CardBaseInfo对象
     * 2、然后根据CardBaseInfoId查询出唯一的UserBaseInfo对象
     * 3、再根据CardBaseInfoId查询出List<TransListInfo>
     * 4、遍历transListInfos把值放入 List<TransListInfoVo>返回；
     */
    @Override
    public List<TransListInfoVo> getTransList(TransListInfoQo transListInfoQo) {
        List<TransListInfoVo> list = new ArrayList<>();
        CardBaseInfo cardBaseInfo = cardBaseInfoMapper.getObjectByCardId(transListInfoQo.getTransId());
        UserBaseInfo userBaseInfo = userBaseInfoMapper.getObjectByPrimarykey(cardBaseInfo.getUserBaseInfoId());
        List<TransListInfo> transListInfos = transListMapper.getObjectByForeignKey(cardBaseInfo.getCardBaseInfoId(), transListInfoQo.getStartTime(), transListInfoQo.getEndTime());
        for (TransListInfo transListInfo : transListInfos) {
            TransListInfoVo transListInfoVo = new TransListInfoVo();
            transListInfoVo.setSerialNumber(transListInfo.getSerialNumber());
            transListInfoVo.setTransAmount(transListInfo.getTransAmount());
            transListInfoVo.setTransTime(transListInfo.getTransTime());
            transListInfoVo.setTransType(transListInfo.getTransType());
            transListInfoVo.setTransName(userBaseInfo.getUserName());
            transListInfoVo.setTransId(cardBaseInfo.getCardId());
            transListInfoVo.setTransCardType(cardBaseInfo.getCardType());
            list.add(transListInfoVo);
        }
        return list;
    }


    @Override
    public String transferByMoney(CardBaseInfoVo cardBaseInfoVo) {
        UserBaseInfo receiptMan = null;
        CardBaseInfo receiptCard = cardBaseInfoMapper.getObjectByCardId(cardBaseInfoVo.getReceiptCardId());
        if (receiptCard == null) {
            return "收款账号不存在，请重新输入";
        } else if (!receiptCard.getCardType().equals("借记卡")) {
            return "收款账号的类型为：" + receiptCard.getCardType() + "，该类型卡，不能进行转账操作！";
        } else {
            receiptMan = userBaseInfoMapper.getObjectByPrimarykey(receiptCard.getUserBaseInfoId());
            if (!cardBaseInfoVo.getReceiptName().equals(receiptMan.getUserName()))
                return "收款账号与收款人不匹配，请再次确认";
        }
        switch (receiptCard.getStat()) {
            case "挂失":
                return "转账失败，收款账号处于挂失状态";
            case "注销":
                return "转账失败，收款账号已注销";
            case "冻结":
                return "转账失败，收款账号处于冻结状态";
        }
        cardBaseInfoMapper.receipt(receiptCard.getCardId(), cardBaseInfoVo.getAmount());

        /*添加现金转账交易明细*/
        String merchandiseDate = DateUtils.dataToStr1(new Date());
        String transListInfoId = UUID.randomUUID().toString();
        String serialNumber = DateUtils.getOrderOID();
        transListMapper.addTransList(transListInfoId, receiptCard.getCardBaseInfoId(), serialNumber, cardBaseInfoVo.getAmount(), "收款", merchandiseDate);
        return "现金转账成功";
    }

}
