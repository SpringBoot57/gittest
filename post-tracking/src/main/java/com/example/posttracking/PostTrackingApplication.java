
package com.example.posttracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@org.springframework.cache.annotation.EnableCaching
@EnableAsync
@SpringBootApplication
public class PostTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostTrackingApplication.class, args);
    }
}
