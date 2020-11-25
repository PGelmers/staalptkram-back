package com.martkplaats.backend.controllers;

import com.martkplaats.backend.model.Image;
import com.martkplaats.backend.model.Product;
import com.martkplaats.backend.repositories.ImageRepository;
import com.martkplaats.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImageRepository imageRepository;

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

    @GetMapping("/product/{id}")
    Optional<Product> getProduct(@PathVariable int id) { return productRepository.findById(id); }

    @DeleteMapping("/product/deleteimage/{productId}/{imageId}")
    boolean deleteImage(@PathVariable int productId, @PathVariable long imageId) {
        System.out.println("IN HERE!");
        Product product = productRepository.findById(productId).get();
        System.out.println(product);
        Image image = imageRepository.findById(imageId).get();
        boolean success = product.deleteImage(image);
        System.out.println(success);
        if( success ) {
            productRepository.save(product);
        }
        return success;
    }
}

