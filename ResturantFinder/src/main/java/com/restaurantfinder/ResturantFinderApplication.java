package com.restaurantfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.restaurantfinder"})
public class ResturantFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResturantFinderApplication.class, args);
	}
}
