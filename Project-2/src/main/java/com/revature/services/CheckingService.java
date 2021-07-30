package com.revature.services;

import java.util.List;

 
import com.revature.daos.CheckingDAO;
import com.revature.daos.CheckingInterface;
import com.revature.models.Checking;
 

public class CheckingService {
	
	
	
	private CheckingDAO fDAO = new CheckingDAO();
	private CheckingDAO cDAO = new CheckingDAO();
	
	
	public List<Checking> findAllChecking(){
		return fDAO.findAllChecking();
	}
	
	//private CheckingInterface cDAO = new CheckingDAO(int id);
	
	public Checking selectCheckingById(int id) {
		return cDAO.selectCheckingById(id);

}
	
	
}

//selectCheckingById(int id)
//private ReimbursementDAO rDAO = new ReimbursementDAO();
//public Reimbursement getReById(int id) {
//	return rDAO.getReById(id);
//}
// 
