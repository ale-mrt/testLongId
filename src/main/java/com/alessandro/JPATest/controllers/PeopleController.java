package com.alessandro.JPATest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alessandro.JPATest.entities.Person;
import com.alessandro.JPATest.services.PersonService;

@Controller
@RequestMapping("/people")
public class PeopleController {
	@Autowired
	PersonService ps;
	
	@GetMapping("/repoRead")
	@ResponseBody
	public ArrayList<Person> read() {
		ArrayList<Person> al = new ArrayList<>();
		
		for(Person p: ps.readAll()) {
			al.add(p);
		}
		
		return al;
	}

	@GetMapping("/repoEven")
	@ResponseBody
	public ArrayList<Person> getEven(){
		ArrayList<Person> al = new ArrayList<>();
		
		for(Person p: ps.getEvenPeople()) {
			al.add(p);
		}
		return al;
	}
	
	@GetMapping("/repoOdd")
	@ResponseBody
	public ArrayList<Person> getOdd(){
		ArrayList<Person> al = new ArrayList<>();
		
		for(Person p: ps.getOddPeople()) {
			al.add(p);
		}

		return al;
	}
	
	@GetMapping("/daoRead")
	@ResponseBody
	public ArrayList<Person> daoRead(){
		return ps.daoRead();
	}
	
	@GetMapping("/daoGetFirst")
	@ResponseBody
	public Person daoGetFirst(){
		return ps.daoGetFirst();
	}
}
