package com.dahuamiao.account.service;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dahuamiao.account.dao.AccountMapper;
import com.dahuamiao.account.entity.Account;
import com.dahuamiao.common.api.AccountDubboService;
import com.dahuamiao.common.dto.AccountDTO;
import com.dahuamiao.common.enums.RspStatusEnum;
import com.dahuamiao.common.response.ObjectResponse;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description  Dubbo Api Impl
 * @Date Created in 2019/1/23 14:40
 */
@Service
public class AccountDubboServiceImpl implements AccountDubboService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        Account existAccount = accountMapper.selectOne(Wrappers.<Account>lambdaQuery().eq(Account::getUserId, accountDTO.getUserId()));
        boolean updateResult = existAccount.decreaseMoney(accountDTO.getAmount())
                .updateById();
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
