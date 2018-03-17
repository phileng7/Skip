package com.skip.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skip.entity.Order;

@Transactional
@Repository
public class OrderDAO implements IOrderDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public List<Order> getAllOrders() {
		String hql = "FROM Order as ord ORDER BY ord.id";
		return (List<Order>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Order getOrderById(int id) {
		return entityManager.find(Order.class, id);
	}

	@Override
	public void addOrder(Order order) {
		entityManager.persist(order);
	}
	
	@Override
	public String getOrderStatusById(int id) {
		Order ord = getOrderById(id);
		return ord.getStatus();
	}

	@Override
	public void deleteOrder(int id) {
		entityManager.remove(getOrderById(id));
	}

	@Override
	public void setStatusOrder(int id, String status) {
		Order ord = getOrderById(id);
		ord.setStatus(status);
		entityManager.flush();
	}
}
