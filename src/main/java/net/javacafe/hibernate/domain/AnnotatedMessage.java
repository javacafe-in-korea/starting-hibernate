package net.javacafe.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MESSAGES")
public class AnnotatedMessage {
	private Long id;
	private String text;

	public AnnotatedMessage() {
	}

	public AnnotatedMessage(String text) {
		this.text = text;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "MESSAGE_ID")
	public Long getId() {
		return id;
	}

	@Column(name = "MESSAGE_TEXT")
	public String getText() {
		return this.text;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(final String text) {
		this.text = text;
	}
}
