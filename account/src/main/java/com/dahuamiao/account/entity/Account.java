package com.dahuamiao.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.math.BigDecimal;

/**
 * @program: seata-test
 * @description:
 * @author: wangJun
 * @create: 2020-11-03 19:54
 **/
@TableName("t_account")
public class Account extends Model<Account> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userId;

    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Account decreaseMoney(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
        return this;
    }
}
