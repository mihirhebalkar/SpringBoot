package com.example.Training.DTO;

import jakarta.validation.constraints.*;

public class ProductDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 100, message = "Price should not be less than 100")
    private Double price;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 10, message = "Quantity should not be more than 10")
    private Integer quantity;

    // Default constructor
    public ProductDTO() {}

    // All args constructor
    public ProductDTO(String name, String email, Double price, String description, Integer quantity) {
        this.name = name;
        this.email = email;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
