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
	
}
