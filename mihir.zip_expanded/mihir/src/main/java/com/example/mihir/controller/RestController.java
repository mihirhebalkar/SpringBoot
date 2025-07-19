package com.example.mihir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mihir.service.MessageService;
import com.example.mihir.service.MihirService;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")

public class RestController {
	
//	@GetMapping("/")
//	public String hello() {
//		return "Hello from Spring Boot!!";
//	}
	
//injecting a Object of Other class
	@Autowired
	MessageService msg;
	
	@Autowired
	MihirService service;
	
	@GetMapping("/")
	public String hello()
	{
		return msg.sendMessage();
	}
	
	@GetMapping("/products")
	public List<String> getProducts() {
		return service.getProducts();
	}
	
	@PostMapping("/products")
	public String addProduct(@RequestBody String product) {
		return service.addProducts(product);
	}

}
