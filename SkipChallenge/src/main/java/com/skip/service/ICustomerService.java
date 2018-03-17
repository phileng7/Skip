package com.skip.service;

import java.util.List;

import com.skip.entity.Customer;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int customerId);
    boolean addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
    boolean verifyCustomerAuth(String email, String password);
    //boolean customerExists(String email);
}
