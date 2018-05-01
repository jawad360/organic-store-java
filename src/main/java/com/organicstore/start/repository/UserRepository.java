package com.organicstore.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.organicstore.start.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
