package com.example.gsmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // enables JPA auditing
public class GsMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsMysqlApplication.class, args);
    }

}

