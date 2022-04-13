package com.alessandro.JPATest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandro.JPATest.entities.Car;
import com.alessandro.JPATest.repositories.CarCrudRepository;

@Service
public class CarService {
	@Autowired
	private CarCrudRepository crudCarRepo;
	
	public Iterable<Car> readAll(){
		return crudCarRepo.findAll();
	}
	
	public Iterable<Car> getEvenCars(){
		return crudCarRepo.getEvenCars();
	}
	
	public Iterable<Car> getOddCars(){
		return crudCarRepo.getOddCars();
	}
}
