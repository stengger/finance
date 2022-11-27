package com.example.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.finance.mapper")  //打开包扫描
@SpringBootApplication
public class FinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceApplication.class, args);
    }

}
