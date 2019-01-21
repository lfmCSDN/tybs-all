package com.lifengming.tybs.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lifengming
 * @version 1.0
 * @date 2019-01-18 11:15
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackageClasses = TybsWebApplication.class)
public class TybsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run( TybsWebApplication.class,args );
        System.out.println("================================");
        System.out.println("===========TybsWeb run==========");
        System.out.println("================================");
    }
}
