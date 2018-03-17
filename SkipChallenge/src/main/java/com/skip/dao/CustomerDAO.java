package com.skip.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skip.entity.Customer;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		String hql = "FROM Customer as cust ORDER BY cust.id";
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}
	@Override
	public void updateCustomer(Customer customer) {
		Customer cust = getCustomerById(customer.getId());
		cust.setEmail(customer.getEmail());
		cust.setEmail(customer.getName());
		cust.setAddress(customer.getAddress());
		cust.setCreation(customer.getCreation());
		cust.setPassword(customer.getPassword());
		entityManager.flush();
	}
	@Override
	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));
	}
	@Override
	public boolean verifyCustomerAuth(String email, String password) {
		String hql = "FROM Customer as cust WHERE cust.email = ? and cust.password = ?";
		int count = entityManager.createQuery(hql).setParameter(0, email)
								.setParameter(1, password).getResultList().size();
		return count > 0 ? true : false;
	}
	@Override
	public boolean customerExists(String email) {
		String hql = "FROM Customer as cust WHERE cust.email = ?";
		int count = entityManager.createQuery(hql).setParameter(0, email).getResultList().size();
		return count > 0 ? true : false;
	}
}
