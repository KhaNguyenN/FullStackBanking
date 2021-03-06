package com.revature.controllers;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Customers;
import com.revature.models.CustomersDTO;
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

	public void addCustomer(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		if(req.getMethod().equals("POST")) {
			
			BufferedReader reader = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			
			CustomersDTO cDTO = om.readValue(body, CustomersDTO.class);
			
			Customers newCustomer = new Customers();
			
			newCustomer.setCustomerusername(cDTO.getCustomerusername());
			newCustomer.setCustomerbankpassword(cDTO.getCustomerbankpassword());
			newCustomer.setCustomerfirstName(cDTO.getCustomerfirstname());
			newCustomer.setCustomerlastname(cDTO.getCustomerlastname());
			newCustomer.setCustomeraddress(cDTO.getCustomeraddress());
			newCustomer.setCustomercity(cDTO.getCustomercity());
			newCustomer.setCustomerstate(cDTO.getCustomerstate());
			newCustomer.setCustomerzip(Integer.parseInt(cDTO.getCustomerzip()));
			
			cs.addCustomer(newCustomer);
			
//			{
//				"customerusername": "testAdd",
//				"customerbankpassword": "yes",
//				"customerfirstname": "abc",
//				"customerlastname": "last",
//				"customeraddress": "Brookyln",
//				"customerstate": "NY",
//				"customerzip": "12345"
//			}
			res.setStatus(201);
			res.getWriter().print("Add worked");
		} 
	}
}
