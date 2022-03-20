/**#################################################################
 * 
 **#################################################################*/
package com.demo.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**#################################################################
 * @author ANICET ERIC KOUAME
 * @Date: 20 mars 2017
 * @Description:
 *Author
 *#################################################################*/

@Entity
@Table(name="AUTHOR")
public class Author implements Serializable {

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorId;
	private String name;	
	private String lastName;
	private String language;
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
	
	
}
