package com.cjh.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author cjh
 * @date 2020/7/22
 */
@EnableEurekaServer
@SpringBootApplication
public class StartServer {
    public static void main(String[] args) {
        SpringApplication.run(StartServer.class);
    }
}
