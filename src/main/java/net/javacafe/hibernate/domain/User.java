package net.javacafe.hibernate.domain;

import javax.naming.InvalidNameException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

@Data
@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstname;

	@Column(name = "LIST_NAME")
	private String lastname;

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
}
