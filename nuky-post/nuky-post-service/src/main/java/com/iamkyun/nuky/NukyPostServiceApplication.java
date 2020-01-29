package com.iamkyun.nuky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author kyun
 */
@SpringBootApplication
@EnableJpaRepositories("com.iamkyun.nuky.repository")
@EntityScan({ "com.iamkyun.nuky.data.entity" })
@EnableJpaAuditing
@EnableFeignClients
@EnableCircuitBreaker
public class NukyPostServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NukyPostServiceApplication.class, args);
    }

}