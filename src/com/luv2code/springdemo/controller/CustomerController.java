package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
@Autowired
private CustomerService customerService;
	
	
	
	@GetMapping("/list")
public String listCustomers(Model theModel) {
	//inject customer dao
	List<Customer> theCustomers=customerService.getCustomers();	
	theModel.addAttribute("customers", theCustomers);
	return "list-customers";
}
	@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel) {
	//inject customer dao
	Customer cu = new Customer();
	theModel.addAttribute("customer", cu);
	return "customer-form";
}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer cu) {
		
		customerService.saveCustomer(cu);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")
	int theId, Model theModel) {
		//get the customer from service
	Customer c=customerService.getCustomer(theId);	
	//set customer as model attribute
	theModel.addAttribute("customer", c);
		
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")
	int theId) {
		//delete
	customerService.deleteCustomer(theId);	
	
	
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName")
	String theSearchName, Model theModel) {
		//get the customer from service
	List<Customer> cL=customerService.searchCustomer(theSearchName);	
	
	//set customer as model attribute
	theModel.addAttribute("customers", cL);
		
		return "list-customers";
	}
	
}
