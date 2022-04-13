package com.alessandro.JPATest.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alessandro.JPATest.entities.Car;

public interface CarCrudRepository extends CrudRepository<Car, Integer>{
	@Query(value="select * from cars where id%2 = 1", nativeQuery=true)
	Iterable<Car> getOddCars();
	
	@Query(value="select * from cars where id%2 = 0", nativeQuery=true)
	Iterable<Car> getEvenCars();
}
