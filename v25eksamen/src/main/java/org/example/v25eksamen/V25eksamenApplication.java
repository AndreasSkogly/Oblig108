package org.example.v25eksamen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"controller", "model"})

@SpringBootApplication
public class V25eksamenApplication {
    public static void main(String[] args) {
        SpringApplication.run(V25eksamenApplication.class, args);
    }

}
