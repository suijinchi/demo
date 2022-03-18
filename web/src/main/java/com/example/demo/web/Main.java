package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 主类，入口类
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(value = {
        "com.example.demo.web",
        "com.example.demo.service",
        "com.example.demo.impl",
        "com.example.demo.dao"})
@EnableConfigurationProperties
@EnableScheduling
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ApplicationContext context =  SpringApplication.run(Main.class, args);
            LOGGER.info("spring.application.name={}, spring.profiles.active={}",
                    context.getEnvironment().getProperty("spring.application.name"),
                    context.getEnvironment().getActiveProfiles());
        } catch (Throwable e) {
            LOGGER.info(e.getMessage());
        }

    }

}
