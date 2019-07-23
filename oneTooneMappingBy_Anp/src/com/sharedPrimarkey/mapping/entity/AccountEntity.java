package com.sharedPrimarkey.mapping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class AccountEntity {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int acc_Id;
	private long acc_Number;
	
	@OneToOne(mappedBy="accountEntity")
	private EmployeeEntity employeeEntity;

	public AccountEntity() {
		System.out.println("Created:"+this.getClass().getSimpleName());
	}
	
	public int getAcc_Id() {
		return acc_Id;
	}
	public void setAcc_Id(int acc_Id) {
		this.acc_Id = acc_Id;
	}
	public long getAcc_Number() {
		return acc_Number;
	}
	public void setAcc_Number(long acc_Number) {
		this.acc_Number = acc_Number;
	}

	@Override
	public String toString() {
		return "AccountEntity [acc_Id=" + acc_Id + ", acc_Number=" + acc_Number + "]";
	}

	
	
	
}
