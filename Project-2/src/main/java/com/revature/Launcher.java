package com.revature;

import java.util.List;
import com.revature.daos.CheckingDAO;
import com.revature.daos.CustomersDAO;
import com.revature.daos.SavingsDAO;
import com.revature.daos.CreditCardsDAO;
import com.revature.models.Checking;
import com.revature.models.CreditCards;
import com.revature.models.Customers;
import com.revature.models.Savings;

public class Launcher {
	//instantiating classes
	private static CustomersDAO cDAO = new CustomersDAO();
	private static CheckingDAO checkingDAO = new CheckingDAO();
	private static CreditCardsDAO CreditCardsDAO = new CreditCardsDAO();
	
	public static void main(String[] args) {
		
		//TESTING FOR JAVA APPLICATION
		//----------------------------
		
		//Shows all of the information on the Checking table
		List<Checking> checkingList = checkingDAO.findAllChecking();
		
		for(Checking checking : checkingList) {
			System.out.println(checking);
		}
		
		//Shows all of the information on the CreditCards table
		List<CreditCards> CreditCardsList = CreditCardsDAO.findAllCreditCards();
		
		for(CreditCards creditcards : CreditCardsList) {
			System.out.println(creditcards);
		}
		
		//Shows all of the information on the Savings table
		List<Savings> SavingsList = SavingsDAO.findAllSavings();
		
		for(Savings savings : SavingsList) {
			System.out.println(savings);
		}	
		
		
		//Shows all of the information on the Customers table
		List<Customers> cList = cDAO.findAllCustomers();
		
		for(Customers c : cList) {
			System.out.println(c);
		}
				
	}
}


