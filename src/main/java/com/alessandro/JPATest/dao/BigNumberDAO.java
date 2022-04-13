package com.alessandro.JPATest.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.alessandro.JPATest.entities.BigNumber;

public class BigNumberDAO {
	private EntityManagerFactory emf;
	
	public BigNumberDAO() {
		this.emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
	}
	
	public EntityManager getEntityManager() {
		EntityManager em = this.emf.createEntityManager();
		
		return em;
	}
	
	public ArrayList<BigNumber> daoRead(){
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<BigNumber> criteria = cb.createQuery(BigNumber.class);
		criteria.select(criteria.from(BigNumber.class));
		
		TypedQuery<BigNumber> tq = this.getEntityManager().createQuery(criteria);
		
		return (ArrayList<BigNumber>) tq.getResultList();
	}
}
