package com.sbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

import service.EurekaServiceDataProvider;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
@EnableTurbine
public class GatewayApplication {
	
	@Bean
	public  EurekaServiceDataProvider  investmentDataControllerClient()
	{
		return  new EurekaServiceDataProvider();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
