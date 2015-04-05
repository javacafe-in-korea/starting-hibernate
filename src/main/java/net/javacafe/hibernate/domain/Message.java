package net.javacafe.hibernate.domain;
/*
public class Message {
	private Long id;
	private String text;
	private Message nextMessage;

	Message() {
	}

	public Message(final String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public Message getNextMessage() {
		return nextMessage;
	}

	public void setNextMessage(final Message nextMessage) {
		this.nextMessage = nextMessage;
	}

}
*/

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
public class Message {
	
	@Id
	@GeneratedValue
	@Column(name = "MESSAGE_ID")
	private Long id;
	
	@Column(name = "MESSAGE_TEXT")
	private String text;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NEXT_MESSAGE_ID")
	private Message nextMessage;
	
	private Message() {
		
	}
	
	public Message(String text) {
		this.text = text;
	}
	
	public Long getId() {
		return id;
	}
	
	private void setId(Long id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Message getNextMessage() {
		return nextMessage;
	}
	
	public void setNextMessage(Message nextMessage) {
		this.nextMessage = nextMessage;
	}
}