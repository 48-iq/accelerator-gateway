package ru.accelerator.sdt.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	DateTimeFormatter dateFormatter() {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy");
	}

	@Bean
	DateTimeFormatter timeFormatter() {
		return DateTimeFormatter.ofPattern("HH:mm");
	}

	@Bean
	DateTimeFormatter dateTimeFormatter() {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy/HH:mm");
	}

}
