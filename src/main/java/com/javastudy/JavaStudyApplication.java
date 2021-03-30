package com.javastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JavaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaStudyApplication.class, args);
    }

}
