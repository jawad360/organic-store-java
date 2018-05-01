package com.organicstore.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.organicstore.start.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
