package com.muxi.wxchat.start;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"com.muxi.wxchat.services.*","com.muxi.wxchat.function","com.muxi.wxchat.controller","com.muxi.wxchat.quatrz"})
@MapperScan({"com.muxi.wxchat.dao"})
public class StartApplication {

    public static void main(String[] args) {

        SpringApplication.run(StartApplication.class, args);

    }
}
