package com.revature.services;

import java.util.List;

import com.revature.daos.CustomersDAO;
import com.revature.models.Customers;

public class CustomersService {

	private CustomersDAO cDAO = new CustomersDAO();
	
	public List<Customers> findAllCustomers(){
		return cDAO.findAllCustomers();
	}
	
	
	
}
