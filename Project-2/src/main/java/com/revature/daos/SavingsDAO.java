package com.revature.daos;

import java.util.List;
import org.hibernate.Session;

import com.revature.models.Checking;
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
	
	public Savings selectSavingsById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Savings savings = ses.get(Savings.class, id); //get() gets an object straight from the DB, skips the cache 
		//here we're saying "Create a new Author object by getting the Author from the DB that has this id"
		
		HibernateUtil.closeSession();
		return savings; //remember, return ends the method, so we close the Session, then return
	}
	
	public void insertSavings(Savings savings) {
		
		//Open a Session object so that we can connect to the database
		Session ses = HibernateUtil.getSession(); //Note the parallels between ConnectionUtil.getConnection() in JDBC!
		
		ses.save(savings); //Refer to the notes if you don't recognize this method - it's a method for Insert functionality
		
		HibernateUtil.closeSession(); //Close our Session (not super necessary here, but good practice)
		
		//That's the whole insert method!!!
		//DAO methods are significantly cleaner with Hibernate than JDBC
	}
}
