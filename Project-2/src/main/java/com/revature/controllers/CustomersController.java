package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Customers;
import com.revature.services.CustomersService;

public class CustomersController {

	private CustomersService cs = new CustomersService();
	private ObjectMapper om = new ObjectMapper();
	
	public void findAllCustomers(HttpServletResponse res) throws IOException{
		List<Customers> customerList = cs.findAllCustomers();
		
		String json = om.writeValueAsString(customerList); //turn the list into a JSON String
		
		res.getWriter().print(json); //put the JSON into the response object
		
		res.setStatus(200);
	}
	
}
