package com.vj.adstreampro.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableCircuitBreaker
public class AdStreamProReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdStreamProReviewApplication.class, args);
	}

}
