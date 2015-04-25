package net.javacafe.hibernate.model;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.persistence.Embedded;
import javax.persistence.Table;

import lombok.Data;
import antlr.StringUtils;

@Data
@Table(name="USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String loginName;
	private String firstname;
	private String lastname;
	private String username;
	private Address address;
	
	@Embedded
	private Address homeAddress;
	
	@Embedded
	private Address billingAddress;
	
	public User() {
		
	}
	
	public String getName() {
		return firstname + ' ' + lastname;
	}
	public void setName(String name) {
		StringTokenizer t = new StringTokenizer(name);
		firstname = t.nextToken();
		lastname = t.nextToken();
	}
	
	public MonetaryAmount calcShippingCosts(Address fromLocation) {
		return null;
	}
}
