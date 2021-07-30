package com.revature.services;
import java.util.List;

import com.revature.daos.CustomersDAO;
import com.revature.models.Customers;

public class LoginService {

	public boolean login(String username, String password) 
	{
		boolean result = secureLogin(username, password);
		return result;
	}
	
	
	private boolean secureLogin(String username, String password)
	{
		//Creating Ers_Users List and checking the Username and Passwords.
		CustomersDAO CustomersDAO = new CustomersDAO();
		List<Customers> CustomersList = CustomersDAO.findAllCustomers();
	
		boolean result = false; //decline username/password combination by default
		
		for (Customers c: CustomersList)
		{
			String tempUser = c.getCustomerusername();
			String tempPass = c.getCustomerbankpassword();
			if(username.equals(tempUser) && password.equals(tempPass)) {
				result = true;
			}
		}
		return result;
	}
	
	/* Example:
	 * Login Functionality for PostMan: (POST @ http://localhost:8080/P1Demo/login)
	 * 	{
    	"username":"demoMan",
    	"password":"password"
		}
	 */
	
}
