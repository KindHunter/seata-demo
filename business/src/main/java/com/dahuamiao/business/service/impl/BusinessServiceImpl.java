package com.dahuamiao.business.service.impl;

import com.dahuamiao.business.service.BusinessService;
import com.dahuamiao.common.api.OrderDubboService;
import com.dahuamiao.common.api.StorageDubboService;
import com.dahuamiao.common.dto.BusinessDTO;
import com.dahuamiao.common.dto.CommodityDTO;
import com.dahuamiao.common.dto.OrderDTO;
import com.dahuamiao.common.enums.RspStatusEnum;
import com.dahuamiao.common.exception.DefaultException;
import com.dahuamiao.common.response.ObjectResponse;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: seata-test
 * @description:
 * @author: wangJun
 * @create: 2020-11-04 11:09
 **/
@Service
public class BusinessServiceImpl implements BusinessService {


    @Reference
    private StorageDubboService storageDubboService;

    @Reference
    private OrderDubboService orderDubboService;

    private boolean flag = true;


    @Override
    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-seata-example")
    public ObjectResponse handleBusiness(BusinessDTO businessDTO) {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        ObjectResponse<Object> objectResponse = new ObjectResponse<>();
        //1、扣减库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());
        ObjectResponse storageResponse = storageDubboService.decreaseStorage(commodityDTO);
        //2、创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        ObjectResponse<OrderDTO> response = orderDubboService.createOrder(orderDTO);

        //打开注释测试事务发生异常后，全局回滚功能
        if (!flag) {
            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
        }

        if (storageResponse.getStatus() != 200 || response.getStatus() != 200) {
            throw new DefaultException(RspStatusEnum.FAIL);
        }

        objectResponse.setStatus(RspStatusEnum.SUCCESS.getCode());
        objectResponse.setMessage(RspStatusEnum.SUCCESS.getMessage());
        objectResponse.setData(response.getData());
        return objectResponse;
    }
}
