package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.models.Checking;
import com.revature.models.CreditCards;
import com.revature.models.ID_DTO;
//import com.revature.services.CheckingService;
import com.revature.services.CreditCardsService;

public class CreditCardsController {
	
	
	private CreditCardsService as = new CreditCardsService();
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
												  //transform data from JSON -> Java or Java -> JSON
	
	//whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
	public void selectCreditCardsById(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
			
			BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in this section JSON)
			
			StringBuilder stringBuild = new StringBuilder(); //create an empty StringBuilder
			
			String readL = reader.readLine(); //this will read the contents of the BufferedReader into a String
			
			while(readL != null) { //while there is data to read from the response data (res -> reader -> line)
				stringBuild.append(readL); //add the contents of "line" to the StringBuilder
				readL = reader.readLine(); //assign line to the next line of data in the reader
				//so for every line of data that received from the response, 
				//this will append it to the StringBuilder 
				//So we get all this previously JSON into one StringBuilder object. Parsing JSON into Java!! cool :)
			}
			
			//ObjectMapper only works with Strings... (not StringBuilders...)
			String body = new String(stringBuild); //so we make a new String to hold the StringBuilder content
			
			//Use the ObjectMapper to read our JSON username/password (which is now a Java String) 
			//remember the readValue() method of ObjectMapper turns JSON into Java
			//and put it into a LoginDTO class as fields
			ID_DTO ID_DTO = om.readValue(body, ID_DTO.class); //we created a LoginDTO using the JSON-turned-Java using read value method
			
			List<CreditCards> creditcardsList = as.findAllCreditCards(); //get a checking list
			List sortedCreditCardsList = new ArrayList();
			
			int ID_DTOint = Integer.parseInt(ID_DTO.getId()); //turning our java object (String) into an integer
		
			for (CreditCards creditcards:creditcardsList)
			{
				if (ID_DTOint == creditcards.getCustomers().getId())
				{
					System.out.println(creditcards);
					sortedCreditCardsList.add(creditcards);
				}
				//System.out.println(checking.getId());
				//System.out.println(checking);
				//System.out.println(checking.getCustomers());
			}
			
			String json = om.writeValueAsString(sortedCreditCardsList); //turn that List in a JSON String
			res.getWriter().print(json); //put the JSON into the response object (res)
			res.setStatus(200); //override the default 404 status code that we set in the MasterServlet
		}
	}
		//List<Checking> checkingList = as.findAllChecking(); //get the List of Expenses 
		//String json = om.writeValueAsString(checkingList); //turn that List in a JSON String	
		//res.getWriter().print(json); //put the JSON into the response object (res)
		//res.setStatus(200); //override the default 404 status code that we set in the MasterServlet
	
	

}









//private CreditCardsService as = new CreditCardsService();
//private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
//											  //transform data from JSON -> Java or Java -> JSON
//
////whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
//public void selectCreditCardsById(HttpServletResponse res) throws IOException {
//	    
//	List<CreditCards> creditcardsList = as.findAllCreditCards(); //get the List of Expenses 
//	String json = om.writeValueAsString(creditcardsList); //turn that List in a JSON String	
//	res.getWriter().print(json); //put the JSON into the response object (res)
//	res.setStatus(200); //override the default 404 status code that we set in the MasterServlet
//	
//}