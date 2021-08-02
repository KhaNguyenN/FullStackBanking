package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.CheckingDAO;
import com.revature.daos.CreditCardsDAO;
import com.revature.daos.SavingsDAO;
import com.revature.models.AmountDTO;
import com.revature.models.Checking;
import com.revature.models.CreditCards;
import com.revature.models.Customers;
import com.revature.models.ID_DTO;
import com.revature.models.Savings;
import com.revature.services.CheckingService;
import com.revature.services.CreditCardsService;
import com.revature.services.SavingsService;

public class SavingsController {
	
	private SavingsService ss = new SavingsService();
	private CreditCardsService cc = new CreditCardsService();
	private CheckingService cs = new CheckingService();
	
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
												  //transform data from JSON -> Java or Java -> JSON
	
	private CheckingDAO CheckingDAO = new CheckingDAO();
	private SavingsDAO SavingsDAO = new SavingsDAO();
	private CreditCardsDAO CreditCardsDAO = new CreditCardsDAO();
	
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
		
		

		public void savingsToChecking(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
		{
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
				
				AmountDTO AmountDTO = om.readValue(body, AmountDTO.class); //we created a AmountDTO using the JSON-turned-Java using read value method
				
				//-----------------CREATE SORTED LIST--------------------------
				List<Savings> savingsList = ss.findAllSavings(); //get a checking list
				
				List sortedSavingsList = new ArrayList();
				
				int AmountDTOid = Integer.parseInt(AmountDTO.getId());
				double AmountDTOamount = Double.parseDouble(AmountDTO.getAmount());
				double savingsTransTotal = 0.0;
				String customerusername = "";
				String customerbankpassword = "";
				String customerfirstname = "";
				String customerlastname = "";
				String customeraddress = "";
				String customercity = "";
				String customerstate = "";
				int customerzip = 0;
				String savingstransdate = "DateTest";
				Integer savingstranstype = 2;
				String savingstransdescription = "Savings To Checking";
				
				for (Savings savings: savingsList)
				{
					if (AmountDTOid == savings.getCustomers().getId())
					{
						sortedSavingsList.clear();
						sortedSavingsList.add(savings);
						savingsTransTotal = savings.getSavingstranstotal();

						//Populating customer information for the constructor
						customerusername = savings.getCustomers().getCustomerusername();
						customerbankpassword = savings.getCustomers().getCustomerbankpassword();
						customerfirstname = savings.getCustomers().getCustomerfirstname();
						customerlastname = savings.getCustomers().getCustomerlastname();
						customeraddress = savings.getCustomers().getCustomeraddress();
						customercity = savings.getCustomers().getCustomercity();
						customerstate = savings.getCustomers().getCustomerstate();
						customerzip = savings.getCustomers().getCustomerzip();
					}
				}

				savingsTransTotal -= AmountDTOamount;
				
				System.out.println(savingsTransTotal);

				//Customer creation should be the same for each method using the DTOid from the user
				//This constructor is used to populate the following contructor (Checking, savings, credit).
				Customers customer1 = new Customers(AmountDTOid, customerusername, customerbankpassword, customerfirstname, customerlastname,
						customeraddress, customercity, customerstate, customerzip);
				
				Double savingstransamount = AmountDTOamount;
				Double savingstranstotal = savingsTransTotal;
						
				//Constructor to populate our (Checking, Savings, Credit) for proper insert.
				Savings savings1 = new Savings(savingstransdate, savingstranstype,	
						savingstransdescription, savingstransamount, savingstranstotal, customer1);
				
				SavingsDAO.insertSavings(savings1);
				
				//---------------------CREATING SORTED LIST 2---------------------------------
				
				List<Checking> checkingList = cs.findAllChecking(); //get a savings list from the Savings Service constructor
				
				List sortedCheckingList = new ArrayList();
				
				
				String checkingtransdate = "DateTest";
				Integer checkingtranstype = 2;
				String checkingtransdescription = "From Checking";
				Double checkingTransTotal = 0.0;
				
				for (Checking checking: checkingList)
				{
					if (AmountDTOid == checking.getCustomers().getId())
					{
						sortedCheckingList.clear();
						sortedCheckingList.add(checking);
						checkingTransTotal = checking.getCheckingtranstotal();
						
						//					//Populating customer information for the constructor
						//					customerusername = savings.getCustomers().getCustomerusername();
						//					customerbankpassword = savings.getCustomers().getCustomerbankpassword();
						//					customerfirstname = savings.getCustomers().getCustomerfirstname();
						//					customerlastname = savings.getCustomers().getCustomerlastname();
						//					customeraddress = savings.getCustomers().getCustomeraddress();
						//					customercity = savings.getCustomers().getCustomercity();
						//					customerstate = savings.getCustomers().getCustomerstate();
						//					customerzip = savings.getCustomers().getCustomerzip();
					}
				}
				
				checkingTransTotal += AmountDTOamount;
				
				System.out.println(checkingTransTotal);

				//			Customer creation should be the same for each method using the DTOid from the user
				//			This constructor is used to populate the following contructor (Checking, savings, credit).
				//			Customers customer2 = new Customers(AmountDTOid, customerusername, customerbankpassword, customerfirstname, customerlastname,
				//					customeraddress, customercity, customerstate, customerzip);
							
				Double checkingtransamount = AmountDTOamount;
				Double checkingtranstotal = checkingTransTotal;
						
				//Constructor to populate our (Checking, Savings, Credit) for proper insert.
				Checking checking1 = new Checking(checkingtransdate, checkingtranstype,	
						checkingtransdescription, checkingtransamount, checkingtranstotal, customer1);
				
				CheckingDAO.insertChecking(checking1);
			
				
				
				//------------------------RESPONDING WITH BOTH SORTED LISTS-------------------
				String json = om.writeValueAsString(sortedSavingsList); //turn that List in a JSON String
				res.getWriter().print(json); //put the JSON into the response object (res)
				
				String json2 = om.writeValueAsString(sortedCheckingList); //turn that List in a JSON String
				res.getWriter().print(json2); //put the JSON into the response object (res)
				
				String json3 = om.writeValueAsString("Savings to Checking"); //turn that List in a JSON String
				res.getWriter().print(json3); //put the JSON into the response object (res)
				
				res.setStatus(200); //override the default 404 status code that we set in the MasterServlet
				//This is where we confirmed it's working
				
				 
			}
		}
		
		
		
		public void savingsToCreditCards(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
		{
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
				
				AmountDTO AmountDTO = om.readValue(body, AmountDTO.class); //we created a AmountDTO using the JSON-turned-Java using read value method
				
				//-----------------CREATE SORTED LIST--------------------------
				List<Savings> savingsList = ss.findAllSavings(); //get a checking list
				
				List sortedSavingsList = new ArrayList();
				
				int AmountDTOid = Integer.parseInt(AmountDTO.getId());
				double AmountDTOamount = Double.parseDouble(AmountDTO.getAmount());
				double savingsTransTotal = 0.0;
				String customerusername = "";
				String customerbankpassword = "";
				String customerfirstname = "";
				String customerlastname = "";
				String customeraddress = "";
				String customercity = "";
				String customerstate = "";
				int customerzip = 0;
				String savingstransdate = "DateTest";
				Integer savingstranstype = 2;
				String savingstransdescription = "Checking To Savings";
				
				for (Savings savings: savingsList)
				{
					if (AmountDTOid == savings.getCustomers().getId())
					{
						sortedSavingsList.clear();
						sortedSavingsList.add(savings);
						savingsTransTotal = savings.getSavingstranstotal();

						//Populating customer information for the constructor
						customerusername = savings.getCustomers().getCustomerusername();
						customerbankpassword = savings.getCustomers().getCustomerbankpassword();
						customerfirstname = savings.getCustomers().getCustomerfirstname();
						customerlastname = savings.getCustomers().getCustomerlastname();
						customeraddress = savings.getCustomers().getCustomeraddress();
						customercity = savings.getCustomers().getCustomercity();
						customerstate = savings.getCustomers().getCustomerstate();
						customerzip = savings.getCustomers().getCustomerzip();
					}
				}

				savingsTransTotal -= AmountDTOamount;
				
				System.out.println(savingsTransTotal);

				//Customer creation should be the same for each method using the DTOid from the user
				//This constructor is used to populate the following contructor (Checking, savings, credit).
				Customers customer1 = new Customers(AmountDTOid, customerusername, customerbankpassword, customerfirstname, customerlastname,
						customeraddress, customercity, customerstate, customerzip);
				
				Double savingstransamount = AmountDTOamount;
				Double savingstranstotal = savingsTransTotal;
						
				//Constructor to populate our (Checking, Savings, Credit) for proper insert.
				Savings savings1 = new Savings(savingstransdate, savingstranstype,	
						savingstransdescription, savingstransamount, savingstranstotal, customer1);
				
				SavingsDAO.insertSavings(savings1);
				
				//---------------------CREATING SORTED LIST 2---------------------------------
				
				List<CreditCards> creditcardsList = cc.findAllCreditCards(); //get a savings list from the Savings Service constructor
				
				List sortedCreditCardsList = new ArrayList();
				

				String creditcardstransdate = "DateTest";
				Integer creditcardstranstype = 2;
				String creditcardstransdescription = "From Checking";
				Double creditcardsTransTotal = 0.0;
				
				for (CreditCards creditcards: creditcardsList)
				{
					if (AmountDTOid == creditcards.getCustomers().getId())
					{
						sortedCreditCardsList.clear();
						sortedCreditCardsList.add(creditcards);
						creditcardsTransTotal = creditcards.getCredittranstotal();
						
						//getCredittranstotal()
						//getCredittranstype()
						//					//Populating customer information for the constructor
						//					customerusername = savings.getCustomers().getCustomerusername();
						//					customerbankpassword = savings.getCustomers().getCustomerbankpassword();
						//					customerfirstname = savings.getCustomers().getCustomerfirstname();
						//					customerlastname = savings.getCustomers().getCustomerlastname();
						//					customeraddress = savings.getCustomers().getCustomeraddress();
						//					customercity = savings.getCustomers().getCustomercity();
						//					customerstate = savings.getCustomers().getCustomerstate();
						//					customerzip = savings.getCustomers().getCustomerzip();
					}
				}
				
				creditcardsTransTotal += AmountDTOamount;
				
				System.out.println(creditcardsTransTotal);

				//			Customer creation should be the same for each method using the DTOid from the user
				//			This constructor is used to populate the following contructor (Checking, savings, credit).
				//	
				
//				this.id = id;
//				this.credittransdate = credittransdate;
//				this.credittranstype = credittranstype;
//				this.credittransdescription = credittransdescription;
//				this.credittransamount = credittransamount;
//				this.credittranstotal = credittranstotal;
//				this.customers = customers;
//				
				//Customers customer2 = new Customers(AmountDTOid, customerusername, customerbankpassword, customerfirstname, customerlastname,
				//					customeraddress, customercity, customerstate, customerzip);
							
				Double credittransamount = AmountDTOamount;
				Double credittranstotal = creditcardsTransTotal;
						
				//Constructor to populate our (Checking, Savings, Credit) for proper insert.
				CreditCards creditcards2 = new CreditCards(creditcardstransdate, creditcardstranstype,	
						creditcardstransdescription, credittransamount, credittranstotal, customer1);
				
				CreditCardsDAO.insertCreditCards(creditcards2);
			
				
				
				//------------------------RESPONDING WITH BOTH SORTED LISTS-------------------
				String json = om.writeValueAsString(sortedCreditCardsList); //turn that List in a JSON String
				res.getWriter().print(json); //put the JSON into the response object (res)
				
				String json2 = om.writeValueAsString(sortedCreditCardsList); //turn that List in a JSON String
				res.getWriter().print(json2); //put the JSON into the response object (res)
				
				String json3 = om.writeValueAsString("Completed Checking to CreditCards"); //turn that List in a JSON String
				res.getWriter().print(json3); //put the JSON into the response object (res)
				
				res.setStatus(200); //override the default 404 status code that we set in the MasterServlet
				//This is where we confirmed it's working
				
				 
			}
		}
		
		
		
		
		
		
		
		
//		public void findAllSavings(HttpServletResponse res) throws IOException {
//			List<Savings> savingsList = cs.findAllSavings();
//			
//			String json = om.writeValueAsString(savingsList); //turn the list into a JSON String
//			
//			res.getWriter().print(json); //put the JSON into the response object
//			
//			res.setStatus(200);
//		}
//		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
