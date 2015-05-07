package net.javacafe.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PARENT_ID")
	private Category parentCategory;

	@OneToMany(mappedBy = "parentCategory")
	private Set<Category> childCategories = new HashSet<>();

	@ManyToMany(mappedBy = "categories")
	private Set<Item> items = new HashSet<>();

	public void addChildCategory(Category child) {
		if (childCategories == null) {
			throw new IllegalArgumentException("Null child category");
		}
		if (child.getParentCategory() != null) {
			child.getParentCategory().getChildCategories().remove(child);
			child.setParentCategory(this);
			childCategories.add(child);
		}
	}
}
