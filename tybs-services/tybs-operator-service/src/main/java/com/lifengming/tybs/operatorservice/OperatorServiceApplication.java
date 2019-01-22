package com.lifengming.tybs.operatorservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lifengming
 */
@ComponentScan(basePackageClasses = OperatorServiceApplication.class)
@MapperScan("com.lifengming.tybs.operatorservice.mapper")
@SpringBootApplication
@EnableEurekaClient
public class OperatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperatorServiceApplication.class, args);
        System.out.println("-----------------------------------------------");
        System.out.println("--------OperatorService run sussessful---------");
        System.out.println("-----------------------------------------------");
    }
}
