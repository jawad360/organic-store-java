package com.organicstore.start.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organicstore.start.model.Order;
import com.organicstore.start.model.User;
import com.organicstore.start.repository.OrderRepository;
import com.organicstore.start.repository.ProductRepository;
import com.organicstore.start.repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;

	public Optional<Order> getOrdersById(String orderId) {
		return orderRepository.findById(orderId);
	}

	public void addOrder(Order order) {
		if (order.getUserId() != null) {
			String userId = order.getUserId();
			Optional<User> user = userRepository.findById(userId);
			if (user.isPresent()) {
				List<Order> orders = user.get().getOrder();
				boolean isOrderPresent = orders.stream().anyMatch(o -> o.getId().equals(order.getId()));
				if(!isOrderPresent) {
					if(orders == null)
						orders = new ArrayList<Order>();
					orders.add(order);
					user.get().setOrder(orders);
					userRepository.save(user.get());
				}
			}
			orderRepository.save(order);
		}
	}
}
