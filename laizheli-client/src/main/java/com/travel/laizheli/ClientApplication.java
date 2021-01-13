package com.travel.laizheli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 旅客平台启动入口
 * create by chen on 2021/1/13
 */
@SpringBootApplication
@MapperScan("com.travel.laizheli.mapper")
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
