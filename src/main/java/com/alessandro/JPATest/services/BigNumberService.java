package com.alessandro.JPATest.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandro.JPATest.dao.BigNumberDAO;
import com.alessandro.JPATest.entities.BigNumber;

@Service
public class BigNumberService {
	@Autowired
	private BigNumberDAO bigNumberDao;
	
	public ArrayList<BigNumber> read(){
		return bigNumberDao.daoRead();
	}
}
