package com.xr.springboot_1_lianxi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.xr.springboot_1_lianxi.dao")
public class Springboot1LianxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot1LianxiApplication.class, args);
    }

}
