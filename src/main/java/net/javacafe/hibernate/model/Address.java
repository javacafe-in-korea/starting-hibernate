package net.javacafe.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	
	@Column(name="ADDRESS_STREET", nullable=false)
	private String street;
	
	@Column(name="ADDRESS_ZIPCODE", nullable=false)
	private String zipcode;
	
	@Column(name="ADDRESS_CITY", nullable=false)
	private String city;
	
	public Address() {}
	
	
}
