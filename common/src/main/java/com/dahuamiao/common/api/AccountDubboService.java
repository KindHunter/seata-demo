package com.dahuamiao.common.api;


import com.dahuamiao.common.dto.AccountDTO;
import com.dahuamiao.common.response.ObjectResponse;

/**
 * @Author: heshouyou
 * @Description  账户服务接口
 * @Date Created in 2019/1/13 16:37
 */
public interface AccountDubboService {

    /**
     * 从账户扣钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);
}
