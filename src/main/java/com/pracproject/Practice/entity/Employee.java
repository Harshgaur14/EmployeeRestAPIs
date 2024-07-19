package com.pracproject.Practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fName;
	
	private String lName;
	
	private String Phoneno;
	
	private String Address;
	
	private long accountNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", Phoneno=" + Phoneno + ", Address="
				+ Address + ", accountNo=" + accountNo + "]";
	}

	public Employee(int id, String fName, String lName, String phoneno, String address, long accountNo) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		Phoneno = phoneno;
		Address = address;
		this.accountNo = accountNo;
	}
	public Employee( String fName, String lName, String phoneno, String address, long accountNo) {
		
		this.fName = fName;
		this.lName = lName;
		Phoneno = phoneno;
		Address = address;
		this.accountNo = accountNo;
	}
	
	public Employee() {
		
	}
	
	
}