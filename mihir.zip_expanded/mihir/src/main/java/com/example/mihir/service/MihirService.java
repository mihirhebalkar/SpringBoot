package com.example.mihir.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MihirService {
	List<String> products = new ArrayList<String>();
	
	public List<String> getProducts() {
		return this.products;
	}
	
	public String addProducts(String product) {
		this.products.add(product);
		return "Products Added successfully";
	}
}
