package com.ProyectoBAsketClub.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ProyectoBAsketClub.repository")
public class ProyectoBAsketClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBAsketClubApplication.class, args);
	}

}
