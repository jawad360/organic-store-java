package com.organicstore.start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organicstore.start.repository.ProductRepository;
import com.organicstore.start.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
}
