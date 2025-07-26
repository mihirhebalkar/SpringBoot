package com.example.mihir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mihir.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	
	
}
