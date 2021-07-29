package com.revature.daos;

import java.util.List;
import org.hibernate.Session;
import com.revature.models.Savings;
import com.revature.utils.HibernateUtil;

public class SavingsDAO {
	//Shows all of the information on the Savings table
	public static List<Savings> findAllSavings() {
		Session ses = HibernateUtil.getSession();
		
		List<Savings> SavingsList = ses.createQuery("FROM Savings").list();
		
		HibernateUtil.closeSession();
		
		return SavingsList;
	}
}
