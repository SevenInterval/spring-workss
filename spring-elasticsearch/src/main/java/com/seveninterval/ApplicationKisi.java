package com.seveninterval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ApplicationKisi {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationKisi.class, args);
    }
}
