package com.organicstore.start.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organicstore.start.model.Inventory;
import com.organicstore.start.model.Vendor;
import com.organicstore.start.repository.InventoryRepository;
import com.organicstore.start.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	private InventoryRepository inventoryRepository;
	
	public List<Vendor> getVendors() {
	    return vendorRepository.findAll();
	}
	
	public void saveVendor(List<Vendor> vendor) {
	    vendorRepository.saveAll(vendor);
	}
	
	public void deleteVendor(String id) {
	    Optional<Vendor> vendorDocumentFound = vendorRepository.findById(id);
	    if(vendorDocumentFound.isPresent()) {
	        Vendor vendorDocument = vendorDocumentFound.get();
	        List<Inventory> inventoryList = vendorDocument.getInventory();
	        if(inventoryList != null && !inventoryList.isEmpty()) {
	            for(Inventory  inventoryDocument : inventoryList) {
	                inventoryDocument.setQuantity(0);
	            }
	            inventoryRepository.saveAll(inventoryList);
	        }
	    }
	}
}
