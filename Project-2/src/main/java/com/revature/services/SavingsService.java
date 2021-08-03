package com.revature.services;

import java.util.List;

import com.revature.daos.SavingsDAO;
import com.revature.models.Checking;
import com.revature.models.Savings;

public class SavingsService {
	
private SavingsDAO sDAO = new SavingsDAO();
private SavingsDAO fDAO = new SavingsDAO();	
	//private CheckingInterface cDAO = new CheckingDAO(int id);

	public List<Savings> findAllSavings(){
	return fDAO.findAllSavings();
}
	
	public Savings selectSavingsById(int id) {
		return sDAO.selectSavingsById(id);
	}	
	public Savings createSavings(Savings savings)
	{
		return savings;
	}	
		



}
