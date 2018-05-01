package com.organicstore.start.controller;

import org.springframework.web.bind.annotation.RestController;

import com.organicstore.start.repository.InventoryRepository;

@RestController
public class InventoryController {
	
	private InventoryRepository inventoryRepository;
}
