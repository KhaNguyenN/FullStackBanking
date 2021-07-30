package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
 
import com.revature.models.Savings;
 
import com.revature.services.SavingsService;

public class SavingsController {
	
	private SavingsService as = new SavingsService();
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
												  //transform data from JSON -> Java or Java -> JSON
	
	//whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
	public void findAllSavings(HttpServletResponse res) throws IOException {
		    
		List<Savings> savingsList = as.findAllSavings(); //get the List of Expenses 
		String json = om.writeValueAsString(savingsList); //turn that List in a JSON String	
		res.getWriter().print(json); //put the JSON into the response object (res)
		res.setStatus(200); //override the default 404 status code that we set in the MasterServlet
		
	}

}
