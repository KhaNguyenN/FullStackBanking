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
	
	
	

		@Id //this makes a field the primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our primary key a serial data type
		@Column(name = "customerid") //otherwise it would just be "id" in the database
		private int id;
		
		@Column(name = "customerusername")
		private String customerusername;
		
		@Column(name = "customerbankpassword")
		private String customerbankpassword;
		
		@Column(name = "customerfirstName")
		private String customerfirstName;
		
		@Column(name = "customerlastName")
		private String customerlastName;
		
		@Column(name = "customeraddress")
		private String customeraddress;
		
		@Column(name = "customercity")
		private String customercity;
		
		@Column(name = "customerstate")
		private String customerstate;
		
		@Column(name = "customerzip")
		private Integer customerzip;
		
//		checkingcustomerid
//		checkingid
		
		@OneToMany(mappedBy="checkingcustomerid", fetch=FetchType.EAGER)
		private List<Checking> checkingacct;
		//what is mappedBy? It's the field in the Book Class that references the checking class 
		//(the Checking Class has an "checkingcustomerid" field)
		//Super necessary if we want this to act like a ManyToMany Relationship

		
		//---------------Boilerplate----------------------------
		
		public Customers() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Customers(int id, String customerusername, String customerbankpassword, String customerfirstName,
				String customerlastName, String customeraddress, String customercity, String customerstate,
				Integer customerzip, List<Checking> checkingacct) {
			super();
			this.id = id;
			this.customerusername = customerusername;
			this.customerbankpassword = customerbankpassword;
			this.customerfirstName = customerfirstName;
			this.customerlastName = customerlastName;
			this.customeraddress = customeraddress;
			this.customercity = customercity;
			this.customerstate = customerstate;
			this.customerzip = customerzip;
			this.checkingacct = checkingacct;
		}
		@Override
		public String toString() {
			return "Customers [id=" + id + ", customerusername=" + customerusername + ", customerbankpassword="
					+ customerbankpassword + ", customerfirstName=" + customerfirstName + ", customerlastName="
					+ customerlastName + ", customeraddress=" + customeraddress + ", customercity=" + customercity
					+ ", customerstate=" + customerstate + ", customerzip=" + customerzip + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((customeraddress == null) ? 0 : customeraddress.hashCode());
			result = prime * result + ((customerbankpassword == null) ? 0 : customerbankpassword.hashCode());
			result = prime * result + ((customercity == null) ? 0 : customercity.hashCode());
			result = prime * result + ((customerfirstName == null) ? 0 : customerfirstName.hashCode());
			result = prime * result + ((customerlastName == null) ? 0 : customerlastName.hashCode());
			result = prime * result + ((customerstate == null) ? 0 : customerstate.hashCode());
			result = prime * result + ((customerusername == null) ? 0 : customerusername.hashCode());
			result = prime * result + ((customerzip == null) ? 0 : customerzip.hashCode());
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
			if (customerfirstName == null) {
				if (other.customerfirstName != null)
					return false;
			} else if (!customerfirstName.equals(other.customerfirstName))
				return false;
			if (customerlastName == null) {
				if (other.customerlastName != null)
					return false;
			} else if (!customerlastName.equals(other.customerlastName))
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
			if (customerzip == null) {
				if (other.customerzip != null)
					return false;
			} else if (!customerzip.equals(other.customerzip))
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
		public String getCustomerfirstName() {
			return customerfirstName;
		}
		public void setCustomerfirstName(String customerfirstName) {
			this.customerfirstName = customerfirstName;
		}
		public String getCustomerlastName() {
			return customerlastName;
		}
		public void setCustomerlastName(String customerlastName) {
			this.customerlastName = customerlastName;
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
		public Integer getCustomerzip() {
			return customerzip;
		}
		public void setCustomerzip(Integer customerzip) {
			this.customerzip = customerzip;
		}
		public List<Checking> getCheckingacct() {
			return checkingacct;
		}
		public void setCheckingacct(List<Checking> checkingacct) {
			this.checkingacct = checkingacct;
		}

		
		 

		 
		

}
