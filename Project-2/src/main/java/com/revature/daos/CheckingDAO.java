package com.revature.daos;

import java.util.List;
import org.hibernate.Session;
import com.revature.models.Checking;
import com.revature.utils.HibernateUtil;

public class CheckingDAO {
	
	//Shows all of the information on the checking table
	public List<Checking> findAllChecking(){
		
		Session ses = HibernateUtil.getSession();
		
		List<Checking> CheckingList = ses.createQuery("FROM Checking").list();
		
		HibernateUtil.closeSession();
		
		return CheckingList;
	}
	
	
	public Checking selectCheckingById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Checking checking = ses.get(Checking.class, id); //get() gets an object straight from the DB, skips the cache 
		//here we're saying "Create a new Author object by getting the Author from the DB that has this id"
		
		HibernateUtil.closeSession();
		return checking; //remember, return ends the method, so we close the Session, then return
	}

	
	public void insertChecking(Checking checking) {
		
		//Open a Session object so that we can connect to the database
		Session ses = HibernateUtil.getSession(); //Note the parallels between ConnectionUtil.getConnection() in JDBC!
		
		ses.save(checking); //Refer to the notes if you don't recognize this method - it's a method for Insert functionality
		
		HibernateUtil.closeSession(); //Close our Session (not super necessary here, but good practice)
		
		//That's the whole insert method!!!
		//DAO methods are significantly cleaner with Hibernate than JDBC
	}
}
