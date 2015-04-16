package net.javacafe.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "parentCategory_id")
	private Category parentCategory;
	@OneToMany(mappedBy="parentCategory")
	private Set<Category> childCategories = new HashSet<Category>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Category> getChildCategories() {
		return java.util.Collections.unmodifiableSet(childCategories);
	}

	public void setChildCategories(Set<Category> childCategories) {
		this.childCategories = childCategories;
	}

	public void addChildCategory(Category category) {
		if( category == null ) {
			throw new IllegalArgumentException("Null category");
		}
		
		if( category.getParentCategory() != null) {
			category.getParentCategory().getChildCategories().remove(category);
		}
		
		category.setParentCategory(this);
		childCategories.add(category);
	}
	
	
}
