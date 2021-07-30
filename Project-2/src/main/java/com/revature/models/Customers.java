package com.revature.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customers") //Calling customers table


public class Customers {
	
//	customerid  SERIAL PRIMARY KEY,  
//	customerusername VARCHAR(50),
//	customerbankpassword VARCHAR(50),
//	customerfirstName VARCHAR(50),
//	customerlastName VARCHAR(50),
//	customeraddress VARCHAR(100),
//	customercity VARCHAR(50),
//	customerstate VARCHAR(2),
//	customerzip INTEGER);
	
	
	/**
	 * CHANGE SCRIPT of customerzip to string instead of int
	 * 
	 */

		@Id //this makes a field the primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our primary key a serial data type
		@Column(name = "customerid") //otherwise it would just be "id" in the database
		private int id;
		
		@Column(name = "customerusername")
		private String customerusername;
		
		@Column(name = "customerbankpassword")
		private String customerbankpassword;
		
		@Column(name = "customerfirstname")
		private String customerfirstname;
		
		@Column(name = "customerlastname")
		private String customerlastname;
		
		@Column(name = "customeraddress")
		private String customeraddress;
		
		@Column(name = "customercity")
		private String customercity;
		
		@Column(name = "customerstate")
		private String customerstate;
		
		@Column(name = "customerzip")
		private int customerzip;
		
//		checkingcustomerid
//		checkingid
		
//		@OneToMany(mappedBy="checkingid", fetch=FetchType.EAGER)
//		private List<Checking> checkingacct;
		//what is mappedBy? It's the field in the Book Class that references the checking class 
		//(the Checking Class has an "checkingcustomerid" field)
		//Super necessary if we want this to act like a ManyToMany Relationship

		
		//---------------Boilerplate----------------------------
		
		public Customers() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Customers(int id, String customerusername, String customerbankpassword, String customerfirstname,
				String customerlastname, String customeraddress, String customercity, String customerstate,
				int customerzip) {
			super();
			this.id = id;
			this.customerusername = customerusername;
			this.customerbankpassword = customerbankpassword;
			this.customerfirstname = customerfirstname;
			this.customerlastname = customerlastname;
			this.customeraddress = customeraddress;
			this.customercity = customercity;
			this.customerstate = customerstate;
			this.customerzip = customerzip;
		}
		
		//No id args consturctor to add new Customers
		public Customers(String customerusername, String customerbankpassword, String customerfirstname,
				String customerlastname, String customeraddress, String customercity, String customerstate,
				int customerzip) {
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

		@Override
		public String toString() {
			return "Customers [id=" + id + ", customerusername=" + customerusername + ", customerbankpassword="
					+ customerbankpassword + ", customerfirstname=" + customerfirstname + ", customerlastname="
					+ customerlastname + ", customeraddress=" + customeraddress + ", customercity=" + customercity
					+ ", customerstate=" + customerstate + ", customerzip=" + customerzip + "]";
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customers other = (Customers) obj;
			if (customeraddress == null) {
				if (other.customeraddress != null)
					return false;
			} else if (!customeraddress.equals(other.customeraddress))
				return false;
			if (customerbankpassword == null) {
				if (other.customerbankpassword != null)
					return false;
			} else if (!customerbankpassword.equals(other.customerbankpassword))
				return false;
			if (customercity == null) {
				if (other.customercity != null)
					return false;
			} else if (!customercity.equals(other.customercity))
				return false;
			if (customerfirstname == null) {
				if (other.customerfirstname != null)
					return false;
			} else if (!customerfirstname.equals(other.customerfirstname))
				return false;
			if (customerlastname == null) {
				if (other.customerlastname != null)
					return false;
			} else if (!customerlastname.equals(other.customerlastname))
				return false;
			if (customerstate == null) {
				if (other.customerstate != null)
					return false;
			} else if (!customerstate.equals(other.customerstate))
				return false;
			if (customerusername == null) {
				if (other.customerusername != null)
					return false;
			} else if (!customerusername.equals(other.customerusername))
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
		public void setCustomerfirstName(String customerfirstname) {
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
		public int getCustomerzip() {
			return customerzip;
		}
		public void setCustomerzip(int customerzip) {
			this.customerzip = customerzip;
		}


		
		 

		 
		

}
