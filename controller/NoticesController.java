package com.example.Spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

	@GetMapping("/notices")
	public String getNoticies() {
		return "Here are the Notices Details from the DB";
	}
	
}
