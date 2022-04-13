package com.alessandro.JPATest.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandro.JPATest.dao.PersonDAO;
import com.alessandro.JPATest.entities.Person;
import com.alessandro.JPATest.repositories.PersonCrudRepository;

@Service
public class PersonService {
	@Autowired
	private PersonCrudRepository crudPersonRepo;
	@Autowired
	private PersonDAO personDao;
	
	public Iterable<Person> readAll(){
		return crudPersonRepo.findAll();
	}
	
	public Iterable<Person> getEvenPeople(){
		return crudPersonRepo.getEvenPeople();
	}
	
	public Iterable<Person> getOddPeople(){
		return crudPersonRepo.getOddPeople();
	}
	
	public ArrayList<Person> daoRead(){
		return personDao.read();
		
	}
	
	public boolean createPerson(Person p) {
		return false;
	}
	
	public int getLastId() {
		return crudPersonRepo.getLastId();
	}
	
	public Person daoGetFirst() {
		return personDao.getFirst();
	}
}
