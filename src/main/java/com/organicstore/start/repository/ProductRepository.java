package com.organicstore.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.organicstore.start.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
