package com.organicstore.start.controller;
import com.organicstore.start.service.InventoryService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organicstore.start.model.Inventory;
import com.organicstore.start.model.Product;
import com.organicstore.start.repository.InventoryRepository;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryService InventoryService;
	
	@GetMapping("/inventory")
	public void getAllInventories() {
	    InventoryService.getInventory();
	}
	
	@GetMapping("/inventory/{id}")
	public void getInventoryById(@PathVariable String id) {
	    InventoryService.getInventory(id);
	}
	
	@GetMapping("/inventory/product/{productId}")
	public void getInventoryByProductId(@PathVariable String productId) {
	    InventoryService.getInventory(productId, true);
	}
	
	@GetMapping("/inventory/category/{categoryId}")
	public void getInventoryByCategoryId(@PathVariable String categoryId) {
	    InventoryService.getInventory(categoryId, false);
	}
	
	@PostMapping("/inventory")
	public void insertInventory(@RequestBody List<Inventory> inventory) {
	    InventoryService.saveInventory(inventory);
	}	
	
	@PutMapping("/inventory")
    public void updateInventory(@RequestBody List<Inventory> inventory) {
        InventoryService.saveInventory(inventory);
    }   
	
}
