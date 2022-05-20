package com.example.mySurferApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.mySurferApplication.DemoApplication")
@EntityScan(basePackages = "com.example.mySurferApplication.DemoApplication")
public class MySurferApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySurferApplication.class, args);
	}

}
