package com.travel.laizheli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 供应商端启动项
 * create by chen on 2021/1/20
 */
@SpringBootApplication
@MapperScan("com.travel.laizheli.mapper")
public class AgentApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgentApplication.class, args);
    }
}
