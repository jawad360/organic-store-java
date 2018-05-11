package com.organicstore.start.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.organicstore.start.model.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String>{

    List<Inventory> findByProductId(String id);

}
