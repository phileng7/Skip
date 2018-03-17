package com.skip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.dao.ICustomerDAO;
import com.skip.entity.Customer;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerDAO customerDAO;
	@Override
	public Customer getCustomerById(int customerId) {
		Customer obj = customerDAO.getCustomerById(customerId);
		return obj;
	}	
	@Override
	public List<Customer> getAllCustomers(){
		return customerDAO.getAllCustomers();
	}
	@Override
	public synchronized boolean addCustomer(Customer customer){
                if (customerDAO.customerExists(customer.getEmail())) {
    	            return false;
                } else {
                	customerDAO.addCustomer(customer);
    	            return true;
                }
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}
	@Override
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
	}
	@Override
	public boolean verifyCustomerAuth(String email, String password) {
		if (customerDAO.verifyCustomerAuth(email, password))
			return true;
		else 
			return false;
	}
}
