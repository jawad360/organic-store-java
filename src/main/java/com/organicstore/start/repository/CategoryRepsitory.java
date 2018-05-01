package com.organicstore.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.organicstore.start.model.Category;

public interface CategoryRepsitory extends MongoRepository<Category, String>{

}
