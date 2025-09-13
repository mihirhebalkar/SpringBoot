package com.example.Training.Controller;

import com.example.Training.DTO.ProductDTO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v2/seller")
public class ProductController {

    List<ProductDTO> products = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/products")
    public List<ProductDTO> getProduct() {
        return this.products;
    }

    @PostMapping("/product")
    public String addProduct(@Valid @RequestBody ProductDTO product) {
        this.products.add(product);
        return "Product: " + product.getName() + " added successfully";
    }

    @PutMapping("/product/{index}")
    public String updateProduct(@PathVariable int index, @Valid @RequestBody ProductDTO updatedProduct) {
        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException("Invalid product index: " + index);
        }
        this.products.set(index, updatedProduct);
        return "Product at index " + index + " updated successfully";
    }

    @DeleteMapping("/product/{index}")
    public String deleteProduct(@PathVariable int index) {
        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException("Invalid product index: " + index);
        }
        ProductDTO removed = this.products.remove(index);
        return "Product: " + removed.getName() + " removed successfully";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now().toString());
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}















