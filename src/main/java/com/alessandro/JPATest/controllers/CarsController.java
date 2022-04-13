package com.alessandro.JPATest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alessandro.JPATest.entities.Car;
import com.alessandro.JPATest.services.CarService;

@Controller
@RequestMapping("/cars")
public class CarsController {
	@Autowired
	CarService cs;
	
	@GetMapping("/repoRead")
	@ResponseBody
	public ArrayList<Car> read() {
		ArrayList<Car> al = new ArrayList<>();
		
		for(Car p: cs.readAll()) {
			al.add(p);
		}
		
		return al;
	}

	@GetMapping("/repoEven")
	@ResponseBody
	public ArrayList<Car> getEven(){
		ArrayList<Car> al = new ArrayList<>();
		
		for(Car p: cs.getEvenCars()) {
			al.add(p);
		}
		return al;
	}
	
	@GetMapping("/repoOdd")
	@ResponseBody
	public ArrayList<Car> getOdd(){
		ArrayList<Car> al = new ArrayList<>();
		
		for(Car p: cs.getOddCars()) {
			al.add(p);
		}
		return al;
	}
}
