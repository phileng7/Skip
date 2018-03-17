package com.skip.dao;

import java.util.List;

import com.skip.entity.Customer;

public interface ICustomerDAO {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int customerId);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
    boolean verifyCustomerAuth(String email, String password);
    boolean customerExists(String email);
}
