package com.operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={GsonAutoConfiguration.class})
public class MathematicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathematicsApplication.class, args);
	}
}
