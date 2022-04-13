package com.alessandro.JPATest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * modello di automobile
 */
@Entity
@Table(name="cars")
public class Car{

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "maker", nullable = false, updatable = false)
	private String maker;
	
	@Column(name = "model", nullable = false, updatable = false)
	private String model;
	
	@Column(name = "year", updatable = false)
	private int year;
	
	/*
	 * relazione con person (in questo caso il proprietario)
	 * @manytoone identifica il tipo di relazione tra car e person;
	 * @joincolumn indica la colonna el db con la quale hibernate fa la join con person
	 * @jsonignore è un'annotazione che evita la ricorsione della stampa nei json: stampando un'auto
	 * si stampa una persona, che ha un'auto, che ha un proprietario, che ha un'auto eccetera: jsonignore si ferma
	 * al passo zero
	 */
	@ManyToOne
	@JoinColumn(name = "person_id")
	@JsonIgnore
	private Person person;
	
	/*
	 * valore transient della classe pojo, ovvero un dato che viene mandato al garbage collector una volta che
	 * non si richiama più. banalmente, per evitare che il db interpreti questo campo come un'effettiva colonna del db
	 */
	@Transient
	private String ownerName;
	
	/*
	 * idem con patate
	 */
	@Transient
	private Integer ownerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getOwnerName() {
		return this.person.getFirst_name()+" "+this.person.getLast_name();
	}
	
	public Integer getOwnerId() {
		return this.person.getId();
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", maker=" + maker + ", model=" + model + ", year=" + year + ", person_id=" + person.getId()
				+ ", ownerName=" + ownerName + "]";
	}
}
