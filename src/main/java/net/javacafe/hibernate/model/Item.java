package net.javacafe.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.sun.jmx.snmp.Timestamp;

@Entity(name="AuctionItem")
@Table(name="ITEM")
@org.hibernate.annotations.BatchSize(size=10)
@org.hibernate.annotations.DiscriminatorFormula(
	"case when ITEM_IS_SPECIAL is not null then A else B end"
)
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
@Data
public class Item {
	private Long id;
	private String name;
	private String description;
	private Timestamp dateModified;
	
	private Set<Category> categories = new HashSet<Category>();

	public void addCategory(Category category) {
		if (category == null)
			throw new IllegalArgumentException("Null category");
		category.getItems().add(this);
		categories.add(category);
	}

}
