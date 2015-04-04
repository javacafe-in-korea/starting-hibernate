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
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "MESSAGE_ID")
	private Long id;

	@Column(name = "MESSAGE_TEXT")
	private String text;

	public AnnotatedMessage() {
	}

	public AnnotatedMessage(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

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
