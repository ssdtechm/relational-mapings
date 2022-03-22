/**#################################################################
 * 
 **#################################################################*/
package com.demo.hibernate.output;

import java.util.ArrayList;
import java.util.List;

import com.demo.hibernate.dao.BookDao;
import com.demo.hibernate.entity.Account;
import com.demo.hibernate.entity.Book;
import com.demo.hibernate.entity.Person;
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
		/*List<Book> bookList = new ArrayList<Book>();
		BookDao b=new BookDao();
		Book book1=new Book();
		Book book2=new Book();
		book1.setAuthor("Siva");
		book1.setPrice(234);
		book1.setTitle("Good To Read");
		
		book2.setAuthor("Kumar");
		book2.setPrice(600);
		book2.setTitle("GodIsHere");		
		bookList.add(book1);
		bookList.add(book2);
		
		
		Student std  = new Student();
				std.setGrade("third");
		        std.setName("Gowri");
		        std.setBooksList(bookList);
		        
		        b.saveStudent(std);*/
		
		Account acc = new Account();
		acc.setAccountNumber(12345345);
		
		
		Person person = new Person();
		person.setPersonName("Srinu");
		person.setPersonEmail("Srinu@gmail.com");
		person.setAccount(acc);
		
		BookDao save = new BookDao();
		save.savePersonDetails(person);
		
		
		
	 }
	
	  
}
