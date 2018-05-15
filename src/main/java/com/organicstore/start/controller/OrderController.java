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

import com.organicstore.start.model.Order;
import com.organicstore.start.repository.OrderRepository;
import com.organicstore.start.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/order/{orderId}")
	public Optional<Order> getOrdersById(@PathVariable String orderId) {
		return orderService.getOrdersById(orderId);
	}

	@PostMapping("/order")
	public void addOrders(@RequestBody Order order) {
		orderService.addOrder(order);
	}
	
	@PutMapping("/order")
	public void updateOrder(@RequestBody Order order) {
		orderService.addOrder(order);
	}
}
