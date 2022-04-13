package com.alessandro.JPATest.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "people")
public class Person {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "first_name", nullable = false, updatable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false, updatable = false)
	private String last_name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "catchphrase")
	private String catchphrase;
	
	@Transient
	private int ownedCars;
	/*
	 * identificazione di una relazione 1-n (in questo caso 1 è la classe attuale Person)
	 * la lista che risulta dalla join delle tabelle people e cars è contenuta in questo campo
	 * di Person. per sapere dove prendersi i campi della join, hibernate ha bisogno del valore mappedBy,
	 * che identifica il campo della classe Car da prendersi per fare la join
	 */
	@OneToMany(mappedBy="person")
	private List<Car> cars;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCatchphrase() {
		return catchphrase;
	}

	public void setCatchphrase(String catchphrase) {
		this.catchphrase = catchphrase;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public int getOwnerCars() {
		return this.cars.size();
	}

	@Override
	public String toString() {
		ArrayList<Integer> carsIds = new ArrayList<>();
		
		for(Car c: cars) {
			carsIds.add(c.getId());
		}
		
		return "Person [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", catchphrase=" + catchphrase + ", cars=" + cars + "]";
	}
}
