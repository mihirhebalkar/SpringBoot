package com.example.B1_Expense.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
}
