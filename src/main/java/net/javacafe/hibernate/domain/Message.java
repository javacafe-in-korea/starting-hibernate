package net.javacafe.hibernate.domain;

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
