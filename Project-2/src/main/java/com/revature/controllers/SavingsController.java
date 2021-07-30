package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Checking;
import com.revature.models.ID_DTO;
import com.revature.models.Savings;
 
import com.revature.services.SavingsService;

public class SavingsController {
	
	private SavingsService ss = new SavingsService();
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
												  //transform data from JSON -> Java or Java -> JSON
	
	//whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
	public void selectSavingsById(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		    
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
			
			List<Savings> savingsList = ss.findAllSavings();
			List sortedSavingsList = new ArrayList();
			
			int ID_DTOint = Integer.parseInt(ID_DTO.getId());
			
			for (Savings savings: savingsList)
			{
					if (ID_DTOint == savings.getCustomers().getId())
					{
						System.out.println(savings);
						sortedSavingsList.add(savings);
					}
			}
			
			String json = om.writeValueAsString(sortedSavingsList); //turn that List in a JSON String
			res.getWriter().print(json); //put the JSON into the response object (res)
			res.setStatus(200); //override the default 404 status code that we set in the MasterServlet

		}
	}
}
