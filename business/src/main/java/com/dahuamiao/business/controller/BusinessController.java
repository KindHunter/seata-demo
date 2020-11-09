package com.dahuamiao.business.controller;

import com.dahuamiao.business.service.BusinessService;
import com.dahuamiao.common.dto.BusinessDTO;
import com.dahuamiao.common.response.ObjectResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seata-test
 * @description:
 * @author: wangJun
 * @create: 2020-11-04 11:07
 **/
@RestController
@RequestMapping("business")
public class BusinessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);


    @Autowired
    private BusinessService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    ObjectResponse handleBusiness(@RequestBody BusinessDTO businessDTO){
        LOGGER.info("请求参数：{}",businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }


    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @PostMapping("/buy2")
    ObjectResponse handleBusiness2(@RequestBody BusinessDTO businessDTO){
        LOGGER.info("请求参数：{}",businessDTO.toString());
        return businessService.handleBusiness2(businessDTO);
    }
}
