package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	public CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers() ;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer cu) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(cu);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String theSearchName) {
		// TODO Auto-generated method stub
		
		return customerDAO.searchCustomer(theSearchName);
	}

}
