package com.mena.userscenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mena.userscenter.mapper")
public class UsersCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersCenterApplication.class, args);
    }

}
