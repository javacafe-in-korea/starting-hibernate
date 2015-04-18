package net.javacafe.hibernate.caveat;

import java.util.HashSet;
import java.util.Set;

public class Item {

	private String name;
	private String description;
	
	private Set categories = new HashSet();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getCategories() {
		return categories;
	}

	public void setCategories(Set categories) {
		this.categories = categories;
	}
}
