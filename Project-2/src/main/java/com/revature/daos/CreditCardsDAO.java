package com.revature.daos;

import java.util.List;
import org.hibernate.Session;
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
		
		
}
