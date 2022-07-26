package com.lingyi.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 咕噜科
 * ClassName: AdminServer
 * date: 2022-07-21 23:26
 * Description:
 * version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.lingyi")
public class AdminServer {

    public static void main(String[] args) {
        SpringApplication.run(AdminServer.class);
        System.out.println("Server start now");
    }

}
