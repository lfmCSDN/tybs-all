package com.lifengming.tybs.webapp.feignclient;

import com.lifengming.tybs.pojo.po.UserOperInfo;
import com.lifengming.tybs.pojo.qo.UserAdminInfoQo;
import com.lifengming.tybs.pojo.qo.UserOperInfoQo;
import com.lifengming.tybs.pojo.vo.UserOperInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lifengming
 */
@FeignClient("zuul-servers")
public interface AdminFeign {
    /**
     * 登录操作员
     *
     * @param admin
     *
     * @return
     */
    @RequestMapping("/admin/admin/login")
    UserOperInfo login(@RequestBody UserAdminInfoQo admin);

    /**
     * 添加操作员
     *
     * @param userOperInfoVo
     *
     * @return
     */
    @RequestMapping("/admin/admin/addOperator")
    String addOperator(@RequestBody UserOperInfoVo userOperInfoVo);

    /**
     * 查询操作员
     *
     * @param userOperInfoQo
     *
     * @return
     */
    @RequestMapping("/admin/admin/getOperator")
    List<UserOperInfoVo> getOperator(@RequestBody UserOperInfoQo userOperInfoQo);

    /**
     * 删除操作员
     *
     * @param userOperInfoQo
     *
     * @return
     */
    @RequestMapping("/admin/admin/deleteOperator")
    String deleteOperator(@RequestBody UserOperInfoQo userOperInfoQo);

    /**
     * 修改操作员
     *
     * @param userOperInfoVo
     *
     * @return
     */
    @RequestMapping("/admin/admin/updateOperator")
    String updateOperator(@RequestBody UserOperInfoVo userOperInfoVo);
}
