package com.alessandro.JPATest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bignumbers")
public class BigNumber implements Serializable{
	private static final long serialVersionUID = 3118939543088310365L;
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="num")
	private int num;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "BigNumber [id=" + id + ", num=" + num + "]";
	}
	
	
}
