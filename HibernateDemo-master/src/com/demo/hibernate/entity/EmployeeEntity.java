package com.demo.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class EmployeeEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String emaiAddrs;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_ID")
	private AccountEntity account;
	
	
	
	public AccountEntity getAccount() {
		return account;
	}
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmaiAddrs() {
		return emaiAddrs;
	}
	public void setEmaiAddrs(String emaiAddrs) {
		this.emaiAddrs = emaiAddrs;
	}
	
	
	

}
