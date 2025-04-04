package com.example.runtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.runtrack.config")
@SpringBootApplication
public class RuntrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuntrackApplication.class, args);
	}

}
