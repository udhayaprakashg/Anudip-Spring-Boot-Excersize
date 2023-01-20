package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mail.entity.Entity;

@Service
public class EmailServiceImpl  implements EmailService {
	
	@Autowired(required = true)
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendSimpleMail(Entity entity) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(sender);
		mailMessage.setTo(entity.getRecipient());
		mailMessage.setText(entity.getMsgBody());
		mailMessage.setSubject("Spring boot Email");
		javaMailSender.send(mailMessage);
		return "Mail Sent Successfully...";
	}

}
