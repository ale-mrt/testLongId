package com.alessandro.JPATest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alessandro.JPATest.entities.BigNumber;
import com.alessandro.JPATest.services.BigNumberService;

@Controller
@RequestMapping("/bigNumbers")
public class BigNumbersController {
	@Autowired
	private BigNumberService bs;
	
	@GetMapping("/read")
	@ResponseBody
	public ArrayList<BigNumber> read() {
		return bs.read();
	}
}
