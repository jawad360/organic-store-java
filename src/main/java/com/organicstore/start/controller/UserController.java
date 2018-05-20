package com.organicstore.start.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organicstore.start.exception.ResourceNotFoundException;
import com.organicstore.start.model.Order;
import com.organicstore.start.model.User;
import com.organicstore.start.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserDetails(@PathVariable String id) {
		return userService.findUserById(id);
	}
	
	@GetMapping("/user/{id}/order")
	public List<Order> getUserOrders(@PathVariable String id) {
		return userService.getUserOrders(id);
	}
	
	@GetMapping("/user/{id}/order/{orderId}")
	public Order getUserOrders(@PathVariable String id, @PathVariable String orderId) {
		return userService.getUserOrderById(id, orderId);
	}
	
	@GetMapping("/user/{id}/orderdetails/{orderId}")
	public Order getUserOrderDetails(@PathVariable String id, @PathVariable String orderId) {
		return userService.getUserOrderDetailsById(orderId);
	}
	
	@PostMapping("/user")
	public void insertUser(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable String id) throws ResourceNotFoundException {
		userService.deleteUser(id);
	}
}
