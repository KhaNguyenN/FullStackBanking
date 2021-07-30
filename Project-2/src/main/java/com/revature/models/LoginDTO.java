package com.revature.models;


//Data Transfer Object. A DTO  a model of some data coming from the client.
//The servlet will parse a JSON object sent by the user, containing their username and password, 
//which gets sent to the controller to be turned into a Java object
//The username and password will be put into this DTO as fields, which will get checked/validated by the service layer
//The DTO is not stored in the database. It's purely for data transfer... Data Transfer Object

public class LoginDTO {
	//username and password sent in by the user stored in these variables
	public	String userName;
	public	String userPass;
	
	//two constructors one with no args and a second one with the variables  so we can instantiate LoginDTO objects
	public LoginDTO() {
		super();
	}
	
	public LoginDTO(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public LoginDTO(String userName) {
		super();
		this.userName = userName;
	}
	
	public void setuserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public String getuserName() {
		return userName;
	}
	
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getuserPass() {
		return userPass;
	}
}