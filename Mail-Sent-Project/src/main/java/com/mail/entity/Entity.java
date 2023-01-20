package com.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
	
	private String recipient;
	private String msgBody;
	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	
	public Entity() {
		
	}
	public Entity(String recipient, String msgBody) {
		super();
		this.recipient = recipient;
		this.msgBody = msgBody;
	}
	

}
