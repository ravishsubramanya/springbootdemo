package co.tracert.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "co.tracert" })
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("starting my demo application....");
		SpringApplication.run(DemoApplication.class, args);
	}
}
