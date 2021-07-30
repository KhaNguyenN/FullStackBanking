package com.revature.daos;

import java.util.List;

import com.revature.models.Checking;

 

public interface CheckingInterface {
	
	public List<Checking> findAllChecking(); //return all the avengers from the database
	
	public Checking selectCheckingById(int id); //take in an int, find the avenger with that id

}
