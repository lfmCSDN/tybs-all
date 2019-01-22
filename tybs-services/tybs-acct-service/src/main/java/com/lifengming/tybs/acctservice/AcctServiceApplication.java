package com.lifengming.tybs.acctservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

/**
 * @author lifengming
 */
@SpringBootApplication
@MapperScan()
@EnableEurekaClient
public class AcctServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcctServiceApplication.class, args);
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----AcctServiceApplication run  sussessful----");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }

    //开启zipkin追踪页面
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
