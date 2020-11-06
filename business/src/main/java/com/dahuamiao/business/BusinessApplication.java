package com.dahuamiao.business;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: seata-test
 * @description:
 * @author: wangJunSeataAutoConfiguration
 * @create: 2020-11-04 11:04
 **/

@EnableDubbo
@SpringBootApplication(scanBasePackages = "com.dahuamiao")
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
