package com.organicstore.start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organicstore.start.repository.ProductRepository;

@Service
public class VendorService {
	
	@Autowired
	private ProductRepository productRepository;
}
