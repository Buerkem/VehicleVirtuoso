package com.example.cardatabase.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository <Car, Long> {
	List<Car> findByBrand(@Param("brand") String brand);
	// Fetch cars by color
	List<Car> findByColor(@Param("color") String color);
	// Fetch cars by year
	List<Car> findByProductionYear(int prod_year);
}