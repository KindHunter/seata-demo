package com.dahuamiao.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @program: seata-test
 * @description:
 * @author: wangJun
 * @create: 2020-11-03 19:18
 **/
@EnableDubbo
@MapperScan("com.dahuamiao.order.dao")
@SpringBootApplication(scanBasePackages = "com.dahuamiao", exclude = DataSourceAutoConfiguration.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
