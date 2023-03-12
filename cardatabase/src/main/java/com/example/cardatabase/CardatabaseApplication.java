package com.example.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarRepository;
import com.example.cardatabase.domain.OwnerRepository;
import com.example.cardatabase.domain.Owner;

@SpringBootApplication
public class CardatabaseApplication {
	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository orepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Add owner objects and save these to db
			Owner owner1 = new Owner("John" , "Johnson");
			Owner owner2 = new Owner("Mary" , "Robinson");
			
			orepository.save(owner1);
			orepository.save(owner2);
			// Add car object with link to owners and save these to db.
			Car car = new Car("Ford", "Mustang", "Red",
			"ADF-1121", 2017, 59000, owner1);
			repository.save(car);
			car = new Car("Nissan", "Leaf", "White",
			"SSJ-3002", 2014, 29000, owner2);
			repository.save(car);
			car = new Car("Toyota", "Prius", "Silver",
			"KKO-0212", 2018, 39000, owner2);
			repository.save(car);
			};
	}
}