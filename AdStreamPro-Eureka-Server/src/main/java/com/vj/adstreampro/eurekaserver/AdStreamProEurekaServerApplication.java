package com.vj.adstreampro.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdStreamProEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdStreamProEurekaServerApplication.class, args);
	}

}
