package com.travel.laizheli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 管理端启动项
 * create by chen on 2021/1/20
 */
@SpringBootApplication
@MapperScan("com.travel.laizheli.dao")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
