package com.demo.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class AccountEntity {
    
	@Id
	@GeneratedValue
	private Long id;
	
	private String accountNo;
	
	@OneToOne(mappedBy = "account")
	private EmployeeEntity empEntity;
	
	
	public EmployeeEntity getEmpEntity() {
		return empEntity;
	}
	public void setEmpEntity(EmployeeEntity empEntity) {
		this.empEntity = empEntity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	
}
