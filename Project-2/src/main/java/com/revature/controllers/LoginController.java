package com.revature.controllers;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {

	ObjectMapper om = new ObjectMapper(); //we will have to inport Jackson databind so we can work with JSON
	private LoginService LoginService = new LoginService();
	
	
	//passing http servlet request and response also need to throw IO exception
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

		if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
			//this process below is to get our JSON String
			
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
			LoginDTO LoginDTO = om.readValue(body, LoginDTO.class); //we created a LoginDTO using the JSON-turned-Java using read value method
			
			System.out.println(LoginDTO);
			res.setStatus(201);
			//control flow to determine what happens in the event of a successful/unsuccessful login--------
			
			if(LoginService.login(LoginDTO.userName, LoginDTO.userPass)) { //if the username/password sent to the service are valid...
				
				HttpSession ses = req.getSession(); //return a Session to hold user info (if one doesn't exist yet)
				//remember, sessions are how you remember the different users on the client
				//this info stays on the server, all the client gets is the request's cookie created by getSession()
				//when a user gets a session, they get a cookie returned that uniquely identifies their session
				ses.setAttribute("user", LoginDTO); //we'll probably just use a USer object if this was forreal
				ses.setAttribute("loggedin", true);
				
				res.setStatus(200); //because login was successful use status code 200
				
				res.getWriter().print("Login Complete"); //we won't see this message anywhere but postman
				
			} else {
				HttpSession ses = req.getSession(false); //this will only return a session if one is already active
				
				if(ses != null) { //if a session exists...
					ses.invalidate(); //kill the session
				}
				res.setStatus(401); //unauthorized
				res.getWriter().print("Error: LoginController.java, No Login"); //we won't see this message anywhere but postman		
			}
		}
	}
}