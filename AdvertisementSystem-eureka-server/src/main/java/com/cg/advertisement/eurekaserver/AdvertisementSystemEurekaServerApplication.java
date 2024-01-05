package com.cg.advertisement.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdvertisementSystemEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertisementSystemEurekaServerApplication.class, args);
	}

}
