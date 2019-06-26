package xml.messagge_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.eureka.model.eurekamodel.model")
public class MessaggeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessaggeServiceApplication.class, args);
	}

}
