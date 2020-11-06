package com.dahuamiao.storage.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dahuamiao.common.api.StorageDubboService;
import com.dahuamiao.common.dto.CommodityDTO;
import com.dahuamiao.common.enums.RspStatusEnum;
import com.dahuamiao.common.response.ObjectResponse;
import com.dahuamiao.storage.dao.StorageMapper;
import com.dahuamiao.storage.entity.Storage;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: seata-test
 * @description:
 * @author: wangJun
 * @create: 2020-11-04 15:58
 **/

@Service
public class StorageServiceImpl implements StorageDubboService {


    @Autowired
    StorageMapper storageMapper;


    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        Storage existStorage = storageMapper.selectOne(Wrappers.<Storage>lambdaQuery().eq(Storage::getCommodityCode, commodityDTO.getCommodityCode()));
        boolean updateResult = existStorage.decreaseAmount(commodityDTO.getCount()).updateById();

        ObjectResponse<Object> response = new ObjectResponse<>();
        if (updateResult){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}
