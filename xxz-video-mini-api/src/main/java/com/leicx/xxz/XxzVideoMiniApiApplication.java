package com.leicx.xxz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.leicx.xxz.mapper")
public class XxzVideoMiniApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxzVideoMiniApiApplication.class, args);
    }

}
