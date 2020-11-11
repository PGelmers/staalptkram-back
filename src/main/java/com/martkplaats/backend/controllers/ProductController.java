package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Product;
import com.martkplaats.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/product")
    Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/products")
    Iterable<Product> findALl() {
        return productRepository.findAll();
    }

    @DeleteMapping("/product/{id}")
    void delete(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
