package com.revature.daos;

import java.util.List;

import com.revature.models.Customers;

public interface CustomersInterface {
	
	public List<Customers> findAllCustomers();
	
	public void addCustomer(Customers customer);
	
	public void updateCustomer(Customers customer);

}
