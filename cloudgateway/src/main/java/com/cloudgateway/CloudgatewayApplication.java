package com.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudgatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("student-service", r -> r.path("/student/**")
                        .uri("lb://STUDENT-SERVICES"))
                .route("school-service", r -> r.path("/school/**")
                        .uri("lb://SCHOOL-SERVICE"))
                .build();
    }
}
