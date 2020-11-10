package com.martkplaats.backend.repositories;

import com.martkplaats.backend.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
