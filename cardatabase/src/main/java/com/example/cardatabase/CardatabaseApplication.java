package com.example.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication {
	@Autowired
	private CarRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			repository.save(new Car("Ford", "Mustang", "Red",
			"ADF-1121", 2017, 59000));
			repository.save(new Car("Nissan", "Leaf", "White",
			"SSJ-3002", 2014, 29000));
			repository.save(new Car("Toyota", "Prius", "Silver",
			"KKO-0212", 2018, 39000));
			};
	}
}