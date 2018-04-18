package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//import org.springframework.cache.annotation.EnableCaching;



@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemoApplication.class, args);
 }
}
