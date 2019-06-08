package com.eureka.model.eurekamodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaModelApplication.class, args);
	}

}
