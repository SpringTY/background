package com.winter.background;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.winter.background.dao")
public class BackgroundApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackgroundApplication.class, args);
    }

}
