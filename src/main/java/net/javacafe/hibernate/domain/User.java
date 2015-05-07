package net.javacafe.hibernate.domain;

import javax.naming.InvalidNameException;
import javax.persistence.Access;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstname;

	@Column(name = "LIST_NAME")
	private String lastname;

	@Access(javax.persistence.AccessType.PROPERTY)
	@Column(name = "FULL_NAME")
	public String getName() {
		return firstname + ' ' + lastname;
	}

	public void setName(String name) {
		this.firstname = name.split(" ")[0];
		this.lastname = name.split(" ")[1];
	}

	public void setFirstName(String firstname) throws InvalidNameException {
		this.firstname = StringUtils.capitalize(firstname);
	}

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "HOME_ZIPCODE")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")) })
	private Address homeAddress;

	@Data
	@Embeddable
	public static class Address {

		@Column(name = "ADDRESS_STREET", nullable = false)
		private String street;
		@Column(name = "ADDRESS_ZIPCODE", nullable = false)
		private String zipcode;
		@Column(name = "ADDRESS_CITY", nullable = false)
		private String city;
	}
}
