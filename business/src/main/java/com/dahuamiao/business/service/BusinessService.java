package com.dahuamiao.business.service;

import com.dahuamiao.common.dto.BusinessDTO;
import com.dahuamiao.common.response.ObjectResponse;

public interface BusinessService {

    ObjectResponse handleBusiness(BusinessDTO businessDTO);
}
