package com.iqmsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MyConfig  {
	
	public static void main(String[] args) {
		SpringApplication.run(MyConfig.class, args);
	}
}
