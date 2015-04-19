package net.javacafe.hibernate.model.pojo;

import java.math.BigDecimal;

public class ItemPojo {
	
	private Long id;
	private String description;
	private BigDecimal initialPrice;
	private UserPojo seller;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}
	
	public UserPojo getSeller() {
		return seller;
	}
	public void setSeller(UserPojo seller) {
		this.seller = seller;
	}
	
}
