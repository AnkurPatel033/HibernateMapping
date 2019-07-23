package com.foreignkey.mapping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class EmployeeEntity {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int id;
	private String email;
	private String fname;
	private String lname;
	
	@OneToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name="account_Id") 
	private AccountEntity accountEntity;

	public EmployeeEntity() {
		System.out.println("Created:"+this.getClass().getSimpleName());
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public AccountEntity getAccount() {
		return accountEntity;
	}

	public void setAccount(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}


	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", accountEntity="
				+ accountEntity + "]";
	}

	

}
