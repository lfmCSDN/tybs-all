package com.lifengming.tybs.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lifengming
 * @version 1.0
 * @date 2019-01-18 11:21
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
        System.out.println("====================================");
        System.out.println("========Eureka Server successful=====");
        System.out.println("=====================================");
    }
}
