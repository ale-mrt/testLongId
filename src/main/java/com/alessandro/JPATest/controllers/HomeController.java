package com.alessandro.JPATest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping({"", "/", "index", "home", "index.html"})
	public String home() {
		return "home.html";
	}
}
