package com.example.xyeta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class XyetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyetaApplication.class, args);
    }

}
