package com.commonTable.mapping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class EmployeeEntity {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int emp_id;
	private String email;
	private String fname;
	private String lname;
	
	/*@OneToOne(cascade = CascadeType.ALL)
 	@JoinTable(name="EMP_ACCT",joinColumns=@JoinColumn(name="emp_id"),
 	inverseJoinColumns=@JoinColumn(name="acc_Id")) */
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="EMPLOYEE_ACCCOUNT", joinColumns = @JoinColumn(name="emp_id"),
	inverseJoinColumns = @JoinColumn(name="acc_Id"))
//	private AccountEntity account;
	private AccountEntity accountEntity;

	public EmployeeEntity() {
		System.out.println("Created:"+this.getClass().getSimpleName());
	}
	
	
	public int getId() {
		return emp_id;
	}

	public void setId(int id) {
		this.emp_id = id;
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
		return "EmployeeEntity [id=" + emp_id + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", accountEntity="
				+ accountEntity + "]";
	}

	

}
