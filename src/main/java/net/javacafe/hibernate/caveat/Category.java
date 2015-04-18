package net.javacafe.hibernate.caveat;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private String name;
	private Category parentCategory;
	private Set childCategories = new HashSet();
	private Set items = new HashSet();
	
	Category() {
	}
	public Category(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	public Set getChildCategories() {
		return childCategories;
	}
	public void setChildCategories(Set childCategories) {
		this.childCategories = childCategories;
	}
	
	public Set getItems() {
		return items;
	}
	public void setItems(Set items) {
		this.items = items;
	}
	
}
