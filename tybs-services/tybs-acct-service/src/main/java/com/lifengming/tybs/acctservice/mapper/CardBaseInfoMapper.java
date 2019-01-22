package com.lifengming.tybs.acctservice.mapper;

import com.lifengming.tybs.pojo.po.CardBaseInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Date:2018/4/4 0004
 * @author lifengming
 */
public interface CardBaseInfoMapper {

    CardBaseInfo getObjectByCardId(String cardId);

    /*付款*/
    boolean payment(@Param("cardId") String cardId, @Param("amount") BigDecimal amount);

    /*收款*/
    boolean receipt(@Param("cardId") String cardId, @Param("amount") BigDecimal amount);

}
