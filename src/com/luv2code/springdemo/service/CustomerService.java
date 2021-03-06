package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {


public void saveCustomer(Customer cu);

public Customer getCustomer(int theId);

public List<Customer> getCustomers();

public void deleteCustomer(int theId);

public List<Customer> searchCustomer(String theSearchName);
}
