package com.dahuamiao.business.service;

import com.dahuamiao.common.dto.BusinessDTO;
import com.dahuamiao.common.response.ObjectResponse;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.transaction.annotation.Transactional;

public interface BusinessService {

    ObjectResponse handleBusiness(BusinessDTO businessDTO);

    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-seata-example")
    ObjectResponse handleBusiness2(BusinessDTO businessDTO);
}
