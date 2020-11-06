package com.dahuamiao.common.api;

import com.dahuamiao.common.dto.CommodityDTO;
import com.dahuamiao.common.response.ObjectResponse;

/**
 * @Author: heshouyou
 * @Description  仓库服务
 * @Date Created in 2019/1/13 16:22
 */
public interface StorageDubboService {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
