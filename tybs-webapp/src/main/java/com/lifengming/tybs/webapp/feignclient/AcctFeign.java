package com.lifengming.tybs.webapp.feignclient;

import com.lifengming.tybs.pojo.qo.TransListInfoQo;
import com.lifengming.tybs.pojo.vo.CardBaseInfoVo;
import com.lifengming.tybs.pojo.vo.TransListInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Date:2018/4/4 0004
 * @author lifengming
 */
@FeignClient("zuul-servers")
@Service
public interface AcctFeign {

    @RequestMapping("/acct/acct/transfer")
    String transfer(@RequestBody CardBaseInfoVo cardBaseInfoVo);

    @RequestMapping("/acct/acct/bankSaving")
    String bankSaving(@RequestBody CardBaseInfoVo cardBaseInfoVo);

    @RequestMapping("/acct/acct/drawMoney")
    String drawMoney(@RequestBody CardBaseInfoVo cardBaseInfoVo);

    @RequestMapping("/acct/acct/getTransList")
    List<TransListInfoVo> getTransList(@RequestBody TransListInfoQo transListInfoQo);

    @RequestMapping("/acct/acct/transferByMoney")
    String transferByMoney(@RequestBody CardBaseInfoVo cardBaseInfoVo);


}
