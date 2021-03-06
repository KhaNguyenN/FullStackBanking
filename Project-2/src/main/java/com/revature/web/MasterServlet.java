package com.revature.web;

import java.io.IOException;
import com.revature.controllers.CustomersController;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.controllers.CheckingController;
import com.revature.controllers.CreditCardsController;
import com.revature.controllers.LoginController;
import com.revature.controllers.SavingsController;
//remember, this is our front controller - ALL requests that come in will have to hit this first.

public class MasterServlet extends HttpServlet {
	
	//instantiate classes
	private LoginController lc = new LoginController();
	private CheckingController checkingcontroller = new CheckingController();
	private SavingsController savingscontroller = new SavingsController();
	private CreditCardsController creditcardscontroller = new CreditCardsController();
  private CustomersController customerscontroller = new CustomersController();


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json"); //set the content of our response object to be JSON
		
		//by default, Tomcat will send back a successful status code (200) if a request gets handled.
		//since we have a master servlet that takes all requests, this means all requests will get hendled.
		//this can lead to problems - we don't want a 200 if the request isn't handled correctly
		//thus, by default, we'll set the status code to 404, and change it in our code upon success.
		res.setStatus(404);
		
		//Now we want to write some code that will determine where requests get sent.
		
		String URI = req.getRequestURI().replace("/FullStack_Banking/", "");
		//getting the request URI, and stripping out the base URL
		//so we'll just be left with the endpoint (e.g. "selectCheckingById", "login") to use in a switch
		
		switch(URI) {
		
		case "login": 
			lc.login(req, res);
			break;
			
			/* Test Login on Postman (POST)
			 { 
    				"userName":"Greglogin",
    				"userPass":"password1"
			 }
			 */
		
		case "selectCheckingById":
			checkingcontroller.selectCheckingById(req, res); //This should request an ID, response should be checking table of that user
			break;
			
			/* Test selectCheckingById on Postman (POST)
			{
		    	"id": "5"
			}
			*/
			
			
		case "selectSavingsById":
			savingscontroller.selectSavingsById(req, res);
			break;
			
			/* Test selectSavingsById on Postman (POST)
			{
		    	"id": "5"
			}
			*/
			
		case "selectCreditCardsById":
			creditcardscontroller.selectCreditCardsById(req,res);
			break;
        
			/* Test selectCreditCardsById on Postman (POST)
			{
		    	"id": "5"
			}
			*/
			
		case "checkingToSavings":
			checkingcontroller.checkingToSavings(req, res);
			break;
		
			/*
			{
		    	"id": "1",
                "amount":"1"
			}
			*/
			
			//done
		case "savingsToChecking":
			savingscontroller.savingsToChecking(req, res);
			break;
		
		case "checkingToCredit": //This method will subtract credit amount and subtract checking amount
			checkingcontroller.checkingToCreditCards(req, res);
			break;
		
		case "savingsToCredit": //This method will subtract credit amount and subtract savings amount
			savingscontroller.savingsToCreditCards(req, res);
			break;
		
		case "createCustomer":
			customerscontroller.addCustomer(req, res);
			break;
			
			/* Test createCustomer on Postman (POST)
			 * {
                "customerusername": "testAdd",
                "customerbankpassword": "yes",
                "customerfirstname": "abc",
                "customerlastname": "last",
                "customeraddress": "Brookyln",
                "customerstate": "NY",
                "customerzip": "12345"
            	}
			 */
			
		//Test Methods
		case "showCustomer": //Use showCustomerByID instead
			customerscontroller.findAllCustomers(res);
			break;
		
		case "showChecking": //Use showCheckingByID instead
			checkingcontroller.findAllChecking(res);
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