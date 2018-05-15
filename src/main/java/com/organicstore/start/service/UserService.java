package com.organicstore.start.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organicstore.start.model.Order;
import com.organicstore.start.model.OrderDetails;
import com.organicstore.start.model.User;
import com.organicstore.start.repository.OrderRepository;
import com.organicstore.start.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	public Optional<User> findUserById(String id) {
		return userRepository.findById(id);
	}

	public void saveUser(User user) {
		if (this.validateUserDocument(user)) {
			if (user.getOrder() != null && !user.getOrder().isEmpty()) {
				for (Order order : user.getOrder()) {
					if (order.getUserId() == null)
						order.setUserId(user.getId());
					if(!validateOrderDocument(order)) {
						return;
					}
				}
				orderRepository.saveAll(user.getOrder());
			}
			userRepository.save(user);
		}
	}

	public boolean validateUserDocument(User user) {
		if(user.getId() == null || user.getId() == "" || user.getName() == null || user.getName() == "" || user.getEmail() == null ||
				user.getEmail() == "" || user.getPassword() == null || user.getPassword() == "" || user.getPhone() == null || user.getPhone() == "")
			return false;
		return true;
	}
	
	public boolean validateOrderDocument(Order order) {
		if(order.getId() == null || order.getId() == "")
			for(OrderDetails orderDetails : order.getOrderDetails())
			if( orderDetails.getInventoryId() == null || orderDetails.getInventoryId() == "" || order.getPrice() == 0.0)
			return false;
		return true;
	}
	
	public void updateUser(User user) {
		if(user.getId() != null && user.getId() != "") {
			boolean isPresent = userRepository.findById(user.getId()).isPresent();
			if(isPresent) {
				User currentUserDocument = userRepository.findById(user.getId()).get();
				User newUser = user;
				user = currentUserDocument;
				if((newUser.getAddress() != null && newUser.getAddress().getPincode() != null && newUser.getAddress().getPincode() != ""))
					user.getAddress().setPincode(newUser.getAddress().getPincode());
				if( (newUser.getName() != null && newUser.getName() != "") )
					user.setName(newUser.getName());
				if((newUser.getEmail() != null &&	newUser.getEmail() != ""))
					user.setEmail(newUser.getEmail());
				if((newUser.getPassword() != null && newUser.getPassword() != ""))
					user.setPassword(newUser.getPassword());
				if((newUser.getPhone() != null && newUser.getPhone() != ""))
					user.setPhone(newUser.getPhone());
				userRepository.save(user);
			}
		}
	}
	
	public void deleteUser(String id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent() && !user.get().getOrder().isEmpty()) {
			List<Order> order = user.get().getOrder();
			for (Order o : order) {
				orderRepository.delete(o);
			}
		}
		userRepository.deleteById(id);
	}

	public List<Order> getUserOrders(String userid) {
		if (userRepository.findById(userid).isPresent())
			return userRepository.findById(userid).get().getOrder();
		return null;
	}
	
	public Order getUserOrderById(String id, String orderId) {
		return userRepository.findByOrderId(orderId);
	}
	
	public Order getUserOrderDetailsById(String orderId) {
		boolean isOrderPresent = orderRepository.findById(orderId).isPresent();
		if(isOrderPresent) {
			List<OrderDetails> orderDetails = orderRepository.findById(orderId).get().getOrderDetails();
			
		}
		return null;
	}
}
