package net.javacafe.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.jmx.snmp.Timestamp;

@Entity
@Table(name="ITEM")
@org.hibernate.annotations.BatchSize(size=10)
@org.hibernate.annotations.DiscriminatorFormula(
	"case when ITEM_IS_SPECIAL is not null then A else B end"
)
public class Item {
	private Long id;
	private String name;
	private String description;
	private Timestamp dateModified;
	
	private Set<Category> categories = new HashSet<Category>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category) {
		if (category == null)
			throw new IllegalArgumentException("Null category");
		category.getItems().add(this);
		categories.add(category);
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}
	
}
