package net.javacafe.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category {
	private Long id;
	private String name;
	private Category parentCategory;
	private Set<Category> childCategories = new HashSet<Category>();
	private Set<Item> items = new HashSet<Item>();
	
	Category() {
	}
	public Category(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORY_ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public Set<Category> getChildCategories() {
		return childCategories;
	}
	public void setChildCategories(Set<Category> childCategories) {
		this.childCategories = childCategories;
	}
	
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
}
