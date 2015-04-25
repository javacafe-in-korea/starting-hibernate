package net.javacafe.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyEntity {

	@Id @GeneratedValue(generator="mySequenceGenerator")
	String id;
}
