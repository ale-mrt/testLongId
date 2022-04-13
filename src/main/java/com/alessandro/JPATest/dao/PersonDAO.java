package com.alessandro.JPATest.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.alessandro.JPATest.entities.Person;

/*
 * A differenza di una repository, un dao moderno viene creato con hibernate utilizzando le hibernate
 * session: in sostanza sono sessioni create ad hoc per la connessione al database e possono essere
 * di due tipologie:
 * - con sessionFactory.getCurrentSession() hibernate gestisce la sessione e la distrugge quando non
 * serve più;
 * - con sessionFactory.openSession() hibernate crea una sessione e lascia al programmatore il compito
 * di gestirla.
 * Con le sessioni hibernate si può astrarre il concetto di query, rendendolo un oggetto, e alla query
 * si possono applicare getter e setter che servono per specificarla in modo oop
 */
public class PersonDAO {
	private EntityManagerFactory emf;
	
	//createEntityManagerFactory è richiesta per creare l'istanza delle factory utili a hibernate, e prende come
	//input una stringa che indica l'unità di persistenza dell'applicazione, dichiarata in persistence.xml
	public PersonDAO() {
		this.emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
	}
	
	//metodo di servizio per creare l'entitymanager on the fly
	public EntityManager getEntityManager() {
		EntityManager em = this.emf.createEntityManager();
		
		return em;
	}
	
	/*
	 * legge da db utilizzando hibernate: questi sono i passi
	 * 
	 * 1 - creazione del criteriabuilder attraverso l'entity manager, una factory di hibernate che restituisce la sessione (connessione al
	 * 	   db in gergo ORM);
	 * 2 - creazione di un criterio attraverso il criteria builder, che verrà caricato con la query da eseguire;
	 * 3 - applicazione al criterio appena creato della query da eseguire mediante sintassi hibernate
	 * 4 - creazione della typedquery, ovvero l'oggetto finale inizializzato col metodo dell'entitymanager createQuery(), dando in input
	 * 	   i criteria creati in precedenza
	 * 5 - restituzione dei risultati della typedquery con getResultList()
	*/
	public ArrayList<Person> read(){
		//criteria builder: come per le date, i vecchi costruttori sono deprecati e si utilizza una classe di servizio criteriabuilder
		//per creare l'entirà che conterrà la query e la eseguirà
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		//creazione del criterio: in hibernate il criterio è un oggetto query che si inizializza e si utilizza in base alle necessità
		CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
		
		//equivalente di select * from people: si applica questa query all'entità query creata in precedenza
		criteria.select(criteria.from(Person.class));
		
		//creazione finale della query
		TypedQuery<Person> tq = this.getEntityManager().createQuery(criteria);
		
		return (ArrayList<Person>) tq.getResultList();
	}
	
	/*
	 * prende il primo risultato di getResultList, che prende tutto quanto, e lo restituisce in json
	 */
	public Person getFirst() {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
		criteria.select(criteria.from(Person.class));
		TypedQuery<Person> tq = this.getEntityManager().createQuery(criteria);
		
		return tq.getResultList().get(0);
	}
}
