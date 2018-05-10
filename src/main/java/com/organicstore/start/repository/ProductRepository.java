package com.organicstore.start.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.organicstore.start.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

    List<Product> findByCategoryId(String categoryId);
    
}
