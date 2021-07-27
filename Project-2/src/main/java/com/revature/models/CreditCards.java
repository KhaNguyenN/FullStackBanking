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
@Table(name = "CreditCards")

public class CreditCards {
	
	@Id //this makes a field the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our primary key a serial data type
	@Column(name = "creditid") //otherwise it would just be "id" in the database
	private int id;
	
	@Column(name = "credittransdate")
	private Date credittransdate;
	
	@Column(name = "credittranstype")
	private Integer credittranstype;
	
	@Column(name = "credittransdescription")
	private String credittransdescription;
	
	@Column(name = "credittransamount")
	private Double credittransamount;
	
	@Column(name = "credittranstotal")
	private Double credittranstotal;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid") //specify with Author column to create a relationship on
	private Customers customers;

	//---------------Boilerplate---------------------------
	public CreditCards() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCards(int id, Date credittransdate, Integer credittranstype, String credittransdescription,
			Double credittransamount, Double credittranstotal, Customers customers) {
		super();
		this.id = id;
		this.credittransdate = credittransdate;
		this.credittranstype = credittranstype;
		this.credittransdescription = credittransdescription;
		this.credittransamount = credittransamount;
		this.credittranstotal = credittranstotal;
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "CreditCards [id=" + id + ", credittranstype=" + credittranstype + ", credittransdescription="
				+ credittransdescription + ", customers=" + customers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credittransdescription == null) ? 0 : credittransdescription.hashCode());
		result = prime * result + ((credittranstype == null) ? 0 : credittranstype.hashCode());
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
		CreditCards other = (CreditCards) obj;
		if (credittransdescription == null) {
			if (other.credittransdescription != null)
				return false;
		} else if (!credittransdescription.equals(other.credittransdescription))
			return false;
		if (credittranstype == null) {
			if (other.credittranstype != null)
				return false;
		} else if (!credittranstype.equals(other.credittranstype))
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

	public Date getCredittransdate() {
		return credittransdate;
	}

	public void setCredittransdate(Date credittransdate) {
		this.credittransdate = credittransdate;
	}

	public Integer getCredittranstype() {
		return credittranstype;
	}

	public void setCredittranstype(Integer credittranstype) {
		this.credittranstype = credittranstype;
	}

	public String getCredittransdescription() {
		return credittransdescription;
	}

	public void setCredittransdescription(String credittransdescription) {
		this.credittransdescription = credittransdescription;
	}

	public Double getCredittransamount() {
		return credittransamount;
	}

	public void setCredittransamount(Double credittransamount) {
		this.credittransamount = credittransamount;
	}

	public Double getCredittranstotal() {
		return credittranstotal;
	}

	public void setCredittranstotal(Double credittranstotal) {
		this.credittranstotal = credittranstotal;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
}
