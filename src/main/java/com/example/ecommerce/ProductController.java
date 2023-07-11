package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{name}")
        public List<Product> getProductByName(@PathVariable String name) {
        return productRepository.getProductByName(name);
    }






}
