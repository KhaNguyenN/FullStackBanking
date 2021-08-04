package com.revature.services;

import java.util.List;

import com.revature.daos.CreditCardsDAO;
 
import com.revature.models.CreditCards;
 

public class CreditCardsService {
	
private CreditCardsDAO cDAO = new CreditCardsDAO();
private CreditCardsDAO fDAO = new CreditCardsDAO();
	
	//private CreditCardsInterface cDAO = new CheckingDAO(int id);

	public List<CreditCards> findAllCreditCards(){
		return fDAO.findAllCreditCards();
}
	
	public CreditCards selectCreditCardsById(int id) {
		return cDAO.selectCreditCardsById(id);
		
//		public CreditCards createCreditCards creditcards)
//		{
//			return creditcards;
//		}	
	//	

}

}
