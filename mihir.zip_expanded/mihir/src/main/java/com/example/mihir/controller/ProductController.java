package com.example.mihir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mihir.entity.ProductEntity;
import com.example.mihir.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public List<ProductEntity> getProducts(){
		return service.getProducts();
	}
	
	@PostMapping("/products")
	public String addProducts(@RequestBody ProductEntity product) {
		return service.addProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public String editProduct(@PathVariable int id, @RequestBody ProductEntity product) {
		return service.editProduct(id, product);
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	
}
