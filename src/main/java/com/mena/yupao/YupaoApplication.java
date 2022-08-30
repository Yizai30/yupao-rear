package com.mena.yupao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.mena.userscenter.mapper")
@EnableScheduling
public class YupaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YupaoApplication.class, args);
    }

}
