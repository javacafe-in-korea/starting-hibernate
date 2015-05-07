package net.javacafe.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "BANK_ACCOUNT")
public class BankAccount extends BillingDetails {

	@Column(name = "ACCOUNT")
	private String account;
	@Column(name = "BANKNAME")
	private String bankname;
	@Column(name = "SWIFT")
	private String swift;
}
