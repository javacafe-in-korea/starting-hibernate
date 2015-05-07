package net.javacafe.hibernate.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Data
@Entity(name = "BILLING_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
public class BillingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Access(AccessType.PROPERTY)
	@Column(name = "BILLING_DETAILS_ID")
	public Long id;

	@Access(AccessType.PROPERTY)
	@Column(name = "OWNER")
	public String owner;

}
