package co.tracert.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = { "co.tracert" })
@EnableEurekaClient
public class TracertApplication {

	public static void main(String[] args) {
		System.out.println("starting tracert-services application....");
		SpringApplication.run(TracertApplication.class, args);
	}
}
