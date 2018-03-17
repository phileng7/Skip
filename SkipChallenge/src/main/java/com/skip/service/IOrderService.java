package com.skip.service;

import java.util.List;

import com.skip.entity.Order;

public interface IOrderService {
	List<Order> getAllOrders();
	Order getOrderById(int id);
	String getOrderStatusById(int id);
	void deleteOrder(int id);
	void setStatusOrder(int id, String status);
	boolean addOrder(Order order);
}
