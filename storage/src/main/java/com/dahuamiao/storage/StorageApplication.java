package com.dahuamiao.storage;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @program: seata-test
 * @description:
 * @author: wangJun
 * @create: 2020-11-04 11:41
 **/

@EnableDubbo
@MapperScan("com.dahuamiao.storage.dao")
@SpringBootApplication(scanBasePackages = "com.dahuamiao", exclude = DataSourceAutoConfiguration.class)
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
