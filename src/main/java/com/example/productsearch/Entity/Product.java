package com.example.productsearch.Entity;

import lombok.Builder;
import lombok.Data;


@Data
public class Product {

    String category;
    String brand;
    String color;
    double price;

    public Product(){}

    @Builder
    public Product(String category, String brand, String color, double price) {
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}
