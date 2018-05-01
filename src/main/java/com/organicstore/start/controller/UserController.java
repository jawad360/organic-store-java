package com.organicstore.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.organicstore.start.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
}
