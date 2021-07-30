package com.revature.daos;

import java.util.List;
import org.hibernate.Session;

import com.revature.models.Checking;
import com.revature.models.CreditCards;
import com.revature.utils.HibernateUtil;

public class CreditCardsDAO {
	
		//Shows all of the information on the CreditCards table
		public List<CreditCards> findAllCreditCards(){
			Session ses = HibernateUtil.getSession();
			
			List<CreditCards> CreditCardsList = ses.createQuery("FROM CreditCards").list();
			
			HibernateUtil.closeSession();
			
			return CreditCardsList;
		}
		
		public CreditCards selectCreditCardsById(int id) {
			
			Session ses = HibernateUtil.getSession();
			
			CreditCards creditcards = ses.get(CreditCards.class, id); //get() gets an object straight from the DB, skips the cache 
			//here we're saying "Create a new Author object by getting the Author from the DB that has this id"
			
			HibernateUtil.closeSession();
			
			return creditcards; //remember, return ends the method, so we close the Session, then return
		}
		
		
}
