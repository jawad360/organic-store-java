package com.organicstore.start.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organicstore.start.model.Category;
import com.organicstore.start.model.Inventory;
import com.organicstore.start.model.Product;
import com.organicstore.start.repository.CategoryRepsitory;
import com.organicstore.start.repository.InventoryRepository;
import com.organicstore.start.repository.ProductRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private CategoryRepsitory categoryRepository;
	
	public List<Inventory> getInventory() {
	    return inventoryRepository.findAll();
	}
	
	public Optional<Inventory> getInventory(String id) {
	    return inventoryRepository.findById(id);
	}
	
	public List<Inventory> getInventory(String id, boolean isProductId) {
	    if(isProductId) {
	        return inventoryRepository.findByProductId(id);
	    } else {
	        return this.getInventoryByCategoryId(id);
	    }
	}
	
	public void saveInventory(List<Inventory> inventory) {
	    inventoryRepository.saveAll(inventory);
	}
	
	private List<Inventory> getInventoryByCategoryId(String categoryId){
	    Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()) {
            List<Product> productList = category.get().getProduct();
            if(productList != null && !productList.isEmpty()) {
                List<Inventory> inventoryList = new ArrayList<Inventory>();
                for(Product productDocument : productList) {
                    String id = productDocument.getId();
                    List<Inventory> inventoryListForProduct = inventoryRepository.findByProductId(id);
                    if(inventoryListForProduct != null && !inventoryListForProduct.isEmpty()) {
                        inventoryList.addAll(inventoryListForProduct);
                    }
                }
                return inventoryList;
            }
        }
        return null;
	}
}
