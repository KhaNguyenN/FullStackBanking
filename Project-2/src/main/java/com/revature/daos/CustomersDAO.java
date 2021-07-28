package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Customers;
import com.revature.utils.HibernateUtil;

public class CustomersDAO {
	
	//Shows all of the information on the Customers table
	public List<Customers> findAllCustomers(){
		
		Session ses = HibernateUtil.getSession();
		
		List<Customers> customerList = ses.createQuery("FROM Customers").list();
		
		HibernateUtil.closeSession();
		
		return customerList;
	}
	
}
