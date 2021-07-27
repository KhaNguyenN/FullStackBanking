package com.revature.models;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Savings")
public class Savings {
	
	@Id //this makes a field the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our primary key a serial data type
	@Column(name = "savingsid") //otherwise it would just be "id" in the database
	private int id;
	
	@Column(name = "savingstransdate")
	private Date savingstransdate;
	
	@Column(name = "savingstranstype")
	private Integer savingstranstype;
	
	@Column(name = "savingstransdescription")
	private String savingstransdescription;
	
	@Column(name = "savingstransamount")
	private Double savingstransamount;
	
	@Column(name = "savingstranstotal")
	private Double savingstranstotal;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid") //specify with Author column to create a relationship on
	private Customers customers;

	//---------------Boilerplate---------------------------
	public Savings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Savings(int id, Date savingstransdate, Integer savingstranstype, String savingstransdescription,
			Double savingstransamount, Double savingstranstotal, Customers customers) {
		super();
		this.id = id;
		this.savingstransdate = savingstransdate;
		this.savingstranstype = savingstranstype;
		this.savingstransdescription = savingstransdescription;
		this.savingstransamount = savingstransamount;
		this.savingstranstotal = savingstranstotal;
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Savings [id=" + id + ", savingstranstype=" + savingstranstype + ", savingstransdescription="
				+ savingstransdescription + ", customers=" + customers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + id;
		result = prime * result + ((savingstransdescription == null) ? 0 : savingstransdescription.hashCode());
		result = prime * result + ((savingstranstype == null) ? 0 : savingstranstype.hashCode());
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
		Savings other = (Savings) obj;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (id != other.id)
			return false;
		if (savingstransdescription == null) {
			if (other.savingstransdescription != null)
				return false;
		} else if (!savingstransdescription.equals(other.savingstransdescription))
			return false;
		if (savingstranstype == null) {
			if (other.savingstranstype != null)
				return false;
		} else if (!savingstranstype.equals(other.savingstranstype))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSavingstransdate() {
		return savingstransdate;
	}

	public void setSavingstransdate(Date savingstransdate) {
		this.savingstransdate = savingstransdate;
	}

	public Integer getSavingstranstype() {
		return savingstranstype;
	}

	public void setSavingstranstype(Integer savingstranstype) {
		this.savingstranstype = savingstranstype;
	}

	public String getSavingstransdescription() {
		return savingstransdescription;
	}

	public void setSavingstransdescription(String savingstransdescription) {
		this.savingstransdescription = savingstransdescription;
	}

	public Double getSavingstransamount() {
		return savingstransamount;
	}

	public void setSavingstransamount(Double savingstransamount) {
		this.savingstransamount = savingstransamount;
	}

	public Double getSavingstranstotal() {
		return savingstranstotal;
	}

	public void setSavingstranstotal(Double savingstranstotal) {
		this.savingstranstotal = savingstranstotal;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	
	
	
	
	

}
