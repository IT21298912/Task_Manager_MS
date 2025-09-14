package com.example.discovery.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced  // ✅ This enables Eureka service discovery
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
