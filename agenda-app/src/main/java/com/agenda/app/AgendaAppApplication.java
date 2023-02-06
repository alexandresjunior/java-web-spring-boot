package com.agenda.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AgendaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaAppApplication.class, args);
	}

}
