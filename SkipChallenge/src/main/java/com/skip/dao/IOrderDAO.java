package com.skip.dao;

import com.skip.entity.Product;

import java.util.List;

import com.skip.entity.Customer;
import com.skip.entity.Order;

public interface IOrderDAO {
	List<Order> getAllOrders();
	Order getOrderById(int id);
	String getOrderStatusById(int id);
	void deleteOrder(int id);
	void setStatusOrder(int id, String status);
	void addOrder(Order order);
	//void addOrder(Order order);
}
