package com.demo.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private int personId;
	private String personName;
	private String personEmail;
	
	
	@OneToOne
	@JoinColumn(name = "accountNumber")
	private Account account;


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public String getPersonEmail() {
		return personEmail;
	}


	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
