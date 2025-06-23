package com.example.aids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AiDocSummarizerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiDocSummarizerApplication.class, args);
    }
}
