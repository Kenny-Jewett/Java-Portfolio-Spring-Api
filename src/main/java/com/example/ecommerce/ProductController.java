package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/products/id/{id}")
    public Optional<Product> getProductById(@PathVariable long id) {
        return productRepository.findById(id);
    }

    @GetMapping("/products/name/{name}")
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

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product newProduct, @PathVariable long id) {
        if(productRepository.existsById(id)) {
            newProduct.setId(id);
            productRepository.save(newProduct);
        } else {
            productRepository.save(newProduct);
        }
    }








}
