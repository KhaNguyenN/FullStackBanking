package com.revature.services;

import java.util.List;

import com.revature.daos.CustomersDAO;
import com.revature.daos.CustomersInterface;
import com.revature.models.Customers;

public class CustomersService {

	private CustomersInterface cDAO = new CustomersDAO();
	
	public List<Customers> findAllCustomers(){
		return cDAO.findAllCustomers();
	}
	
	public void addCustomer(Customers customer) {
		cDAO.addCustomer(customer);
	}
	
	
}
