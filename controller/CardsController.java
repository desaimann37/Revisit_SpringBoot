package com.example.Spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	@GetMapping("/myCards")
	public String getCardDetails() {
		return "Here are the Card Details from the DB";
	}
	
	
}
