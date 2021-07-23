package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//remember, this is our front controller - ALL requests that come in will have to hit this first.
public class MasterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json"); //set the content of our response object to be JSON
		
		//by default, Tomcat will send back a successful status code (200) if a request gets handled.
		//since we have a master servlet that takes all requests, this means all requests will get hendled.
		//this can lead to problems - we don't want a 200 if the request isn't handled correctly
		//thus, by default, we'll set the status code to 404, and change it in our code upon success.
		res.setStatus(404);
		
		
		//Now we want to write some code that will determine where requests get sent.
		
		String URI = req.getRequestURI().replace("/Project-2/", "");
		//getting the request URI, and stripping out the base URL
		//so we'll just be left with the endpoint (e.g. "avengers", "login") to use in a switch
		
		switch(URI) {
		
		case "logout":
			break;
			
		case "login": 
			break;
			
		case "accountCreation":
			break;
			
		case "checking":
			break;
		case "credit":
			break;
			
		case"payChecking":
			break;
			
		case"paySavings":
			break;
			
		case"transferChecking":
			break;
			
		case"transferSavings":
			break;
			
		case"transferHistory":
			break;
			
		case"showTransaction":
			break;
		}
		
	}
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
		//this sends every POST request to the doGet method, why???
		//I only want one switch statement in this Servlet. It can get very messy otherwise
		//and we'll differentiate get from post in the controllers instead of the servlet.
		
	}
	
}