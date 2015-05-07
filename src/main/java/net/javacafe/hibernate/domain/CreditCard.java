package net.javacafe.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "CREDIT_CARD")
@PrimaryKeyJoinColumn(name = "CREDIT_CARD_ID")
public class CreditCard extends BillingDetails {
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "EXP_MONTH")
	private String expMonth;
	@Column(name = "EXP_YEAR")
	private String expYear;

}
