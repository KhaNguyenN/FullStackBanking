package com.revature.models;

public class AmountDTO {
	public String id;
	public String amount;
	
	public AmountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AmountDTO(String id, String amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
