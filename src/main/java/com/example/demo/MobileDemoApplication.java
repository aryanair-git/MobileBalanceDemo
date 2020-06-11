package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.domain.MobileRepository;
//"com.example.demo.domain"


@SpringBootApplication
public class MobileDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileDemoApplication.class, args);
	}

}
