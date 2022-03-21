/**#################################################################
 * 
 **#################################################################*/
package com.demo.hibernate.output;

import java.util.ArrayList;
import java.util.List;

import com.demo.hibernate.dao.BookDao;
import com.demo.hibernate.entity.AccountEntity;
import com.demo.hibernate.entity.Book;
import com.demo.hibernate.entity.Employee;
import com.demo.hibernate.entity.EmployeeEntity;
import com.demo.hibernate.entity.Pancard;
import com.demo.hibernate.entity.Person;
import com.demo.hibernate.entity.Project;
import com.demo.hibernate.entity.Student;

/**#################################################################
 * @author ANICET ERIC KOUAME
 * @Date: 20 mars 2017
 * @Description:
 *Main
 *#################################################################*/

public class Main {

	 /**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	 {
		BookDao b=new BookDao();
			
		EmployeeEntity emp=new  EmployeeEntity();
		emp.setFirstName("Prasanth");
		emp.setLastName("Kumar");
		emp.setEmaiAddrs("prasanth@gmai.com");
		
		AccountEntity account = new AccountEntity();
		account.setAccountNo("82376487-5355");
		
		emp.setAccount(account);
		
		b.saveEmployeeAccount(emp);
		
		
		
	 }
	
	  
}
