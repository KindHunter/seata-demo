package com.dahuamiao.business.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: seata-test
 * @description:
 * @author: wangJun
 * @create: 2020-11-04 11:06
 **/
@Configuration
public class SeataAutoConfig {
//    /**
//     * init global transaction scanner
//     *
//     * @Return: GlobalTransactionScanner
//     */
//    @Bean
//    public GlobalTransactionScanner globalTransactionScanner(){
//        return new GlobalTransactionScanner("dubbo-gts-seata-example", "my_test_tx_group");
//    }
}
