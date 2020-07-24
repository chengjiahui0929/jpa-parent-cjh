package com.cjh.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cjh
 * @date 2020/7/22
 */
@EnableEurekaClient
@SpringBootApplication
public class StartClient {
    public static void main(String[] args) {
        SpringApplication.run(StartClient.class);
    }
}
