package net.javacafe.hibernate.model.pojo;

import java.util.Collection;
import java.util.Set;

public class UserPojo {
	
	private Long id;
	private String username;
	private Collection<ItemPojo> itemsForSale;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Collection<ItemPojo> getItemsForSale() {
		return itemsForSale;
	}
	public void setItemsForSale(Collection<ItemPojo> itemsForSale2) {
		this.itemsForSale = itemsForSale2;
	}
}
