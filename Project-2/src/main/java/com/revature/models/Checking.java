package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Checking")

//checkingid  SERIAL PRIMARY KEY,
//checkingtransDate String,
//checkingtranstype INTEGER,
//checkingtransdescription VARCHAR(50),
//checkingtransamount Double,
//checkingtotal Double,
//checkingcustomerid INTEGER REFERENCES Customers(customer_id));


public class Checking {
	
	@Id //this makes a field the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our primary key a serial data type
	@Column(name = "checkingid") //otherwise it would just be "id" in the database
	private int id;
	
	@Column(name = "checkingtransDate")
	private String checkingtransDate;
	
	@Column(name = "checkingtranstype")
	private Integer checkingtranstype;
	
	@Column(name = "checkingtransdescription")
	private String checkingtransdescription;
	
	@Column(name = "checkingtransamount")
	private Double checkingtransamount;
	
	@Column(name = "checkingtranstotal")
	private Double checkingtranstotal;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid") //specify with Customer column to create a relationship on
	private Customers customers;

	//---------------Boilerplate----------------------------
	
	public Checking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Checking(int id, String checkingtransDate, Integer checkingtranstype, String checkingtransdescription,
			Double checkingtransamount, Double checkingtranstotal, Customers customers) {
		super();
		this.id = id;
		this.checkingtransDate = checkingtransDate;
		this.checkingtranstype = checkingtranstype;
		this.checkingtransdescription = checkingtransdescription;
		this.checkingtransamount = checkingtransamount;
		this.checkingtranstotal = checkingtranstotal;
		this.customers = customers;
	}

	
	public Checking(String checkingtransDate, Integer checkingtranstype, String checkingtransdescription,
			Double checkingtransamount, Double checkingtranstotal, Customers customers) {
		super();
		this.checkingtransDate = checkingtransDate;
		this.checkingtranstype = checkingtranstype;
		this.checkingtransdescription = checkingtransdescription;
		this.checkingtransamount = checkingtransamount;
		this.checkingtranstotal = checkingtranstotal;
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Checking [id=" + id + ", checkingtranstype=" + checkingtranstype + ", checkingtransdescription="
				+ checkingtransdescription + ", customers=" + customers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkingtransdescription == null) ? 0 : checkingtransdescription.hashCode());
		result = prime * result + ((checkingtranstype == null) ? 0 : checkingtranstype.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checking other = (Checking) obj;
		if (checkingtransdescription == null) {
			if (other.checkingtransdescription != null)
				return false;
		} else if (!checkingtransdescription.equals(other.checkingtransdescription))
			return false;
		if (checkingtranstype == null) {
			if (other.checkingtranstype != null)
				return false;
		} else if (!checkingtranstype.equals(other.checkingtranstype))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcheckingtransDate() {
		return checkingtransDate;
	}

	public void setcheckingtransDate(String checkingtransDate) {
		this.checkingtransDate = checkingtransDate;
	}

	public Integer getCheckingtranstype() {
		return checkingtranstype;
	}

	public void setCheckingtranstype(Integer checkingtranstype) {
		this.checkingtranstype = checkingtranstype;
	}

	public String getCheckingtransdescription() {
		return checkingtransdescription;
	}

	public void setCheckingtransdescription(String checkingtransdescription) {
		this.checkingtransdescription = checkingtransdescription;
	}

	public Double getCheckingtransamount() {
		return checkingtransamount;
	}

	public void setCheckingtransamount(Double checkingtransamount) {
		this.checkingtransamount = checkingtransamount;
	}

	public Double getCheckingtranstotal() {
		return checkingtranstotal;
	}

	public void setCheckingtranstotal(Double checkingtranstotal) {
		this.checkingtranstotal = checkingtranstotal;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
}
