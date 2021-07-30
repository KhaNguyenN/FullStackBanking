package com.revature.models;

public class CustomersDTO {
	
	private String customerusername;
	private String customerbankpassword;
	private String customerfirstname;
	private String customerlastname;
	private String customeraddress;
	private String customercity;
	private String customerstate;
	private String customerzip;
	
	
	
	
	public CustomersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public CustomersDTO(String customerusername, String customerbankpassword, String customerfirstname,
			String customerlastname, String customeraddress, String customercity, String customerstate,
			String customerzip) {
		super();
		this.customerusername = customerusername;
		this.customerbankpassword = customerbankpassword;
		this.customerfirstname = customerfirstname;
		this.customerlastname = customerlastname;
		this.customeraddress = customeraddress;
		this.customercity = customercity;
		this.customerstate = customerstate;
		this.customerzip = customerzip;
	}




	public String getCustomerusername() {
		return customerusername;
	}




	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}




	public String getCustomerbankpassword() {
		return customerbankpassword;
	}




	public void setCustomerbankpassword(String customerbankpassword) {
		this.customerbankpassword = customerbankpassword;
	}




	public String getCustomerfirstname() {
		return customerfirstname;
	}




	public void setCustomerfirstname(String customerfirstname) {
		this.customerfirstname = customerfirstname;
	}




	public String getCustomerlastname() {
		return customerlastname;
	}




	public void setCustomerlastname(String customerlastname) {
		this.customerlastname = customerlastname;
	}




	public String getCustomeraddress() {
		return customeraddress;
	}




	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}




	public String getCustomercity() {
		return customercity;
	}




	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}




	public String getCustomerstate() {
		return customerstate;
	}




	public void setCustomerstate(String customerstate) {
		this.customerstate = customerstate;
	}




	public String getCustomerzip() {
		return customerzip;
	}




	public void setCustomerzip(String customerzip) {
		this.customerzip = customerzip;
	}
	
	
	
	
	
	

}
