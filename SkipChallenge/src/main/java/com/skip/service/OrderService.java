package com.skip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.dao.IOrderDAO;
import com.skip.entity.Order;
import com.skip.entity.Product;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private IOrderDAO orderDAO;
	
	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	@Override
	public Order getOrderById(int id) {
		Order obj = orderDAO.getOrderById(id);
		return obj;
	}

	@Override
	public String getOrderStatusById(int id) {
		return orderDAO.getOrderStatusById(id);
	}

	@Override
	public void deleteOrder(int id) {
		orderDAO.deleteOrder(id);
	}

	@Override
	public void setStatusOrder(int id, String status) {
		orderDAO.setStatusOrder(id, status);
	}
	
	@Override
	public boolean addOrder(Order order) {
        if (orderDAO.getOrderById(order.getId())!=null) {
            return false;
        } else {
        	orderDAO.addOrder(order);
            return true;
        }
	}

}
