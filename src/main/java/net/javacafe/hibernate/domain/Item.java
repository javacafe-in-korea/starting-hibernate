package net.javacafe.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ITEM")
public class Item {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany
	@JoinTable(name = "ITEM_CATEGORY", joinColumns = { @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID") })
	private Set<Category> categories = new HashSet<>();

	public void addCategory(Category c) {
		if (c == null) {
			throw new IllegalArgumentException("Null category");
		}
		c.getItems().add(this);
		categories.add(c);
	}
}
