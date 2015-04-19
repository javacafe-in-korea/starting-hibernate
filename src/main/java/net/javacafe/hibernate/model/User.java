package net.javacafe.hibernate.model;

import java.io.Serializable;
import java.util.StringTokenizer;

import antlr.StringUtils;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstname;
	private String lastname;
	private String username;
	private Address address;
	
	public User() {
		
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		
		this.firstname = firstname;
	}
	
	public String getName() {
		return firstname + ' ' + lastname;
	}
	public void setName(String name) {
		StringTokenizer t = new StringTokenizer(name);
		firstname = t.nextToken();
		lastname = t.nextToken();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public MonetaryAmount calcShippingCosts(Address fromLocation) {
		return null;
	}
}
