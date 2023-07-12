package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
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

    @GetMapping("/products/model/{model}")
    public List<Product> getProductByModel(@PathVariable String model) {
        return productRepository.getProductByModel(model);
    }

    @Transactional
    @DeleteMapping("products/{id}")
    public String deleteGreetingById(@PathVariable long id) {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product Deleted";
        } else {
            return "Product not found.";
        }


    }








}
