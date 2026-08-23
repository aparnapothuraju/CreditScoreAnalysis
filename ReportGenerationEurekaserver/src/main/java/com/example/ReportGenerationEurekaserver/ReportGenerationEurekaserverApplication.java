package com.example.ReportGenerationEurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ReportGenerationEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportGenerationEurekaserverApplication.class, args);
	}

}
