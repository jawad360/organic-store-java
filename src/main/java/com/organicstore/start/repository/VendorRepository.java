package com.organicstore.start.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.organicstore.start.model.Vendor;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String>{

}
