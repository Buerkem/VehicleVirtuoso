package com.example.cardatabase.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository <Car, Long> {
	List<Car> findByBrand(String brand);
	// Fetch cars by color
	List<Car> findByColor(String color);
	// Fetch cars by year
	List<Car> findByProductionYear(int prod_year);
}