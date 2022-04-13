package com.alessandro.JPATest.repositories;

import org.springframework.stereotype.Repository;

import com.alessandro.JPATest.entities.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PersonCrudRepository extends CrudRepository<Person, Integer>{
	@Query(value="select * from people where id%2 = 1", nativeQuery=true)
	Iterable<Person> getOddPeople();
	
	@Query(value="select * from people where id%2 = 0", nativeQuery=true)
	Iterable<Person> getEvenPeople();
	
	@Query(value="select id from people order by id desc limit 1", nativeQuery=true)
	int getLastId();
}
