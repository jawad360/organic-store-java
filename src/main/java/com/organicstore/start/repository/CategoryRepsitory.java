package com.organicstore.start.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.organicstore.start.model.Category;

@Repository
public interface CategoryRepsitory extends MongoRepository<Category, String>{
	List<Category> findByProductId(String productId);
}
