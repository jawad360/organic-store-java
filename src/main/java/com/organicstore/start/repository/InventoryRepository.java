package com.organicstore.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.organicstore.start.model.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String>{

}
