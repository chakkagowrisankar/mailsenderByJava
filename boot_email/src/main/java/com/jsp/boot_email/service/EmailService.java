package com.jsp.boot_email.service;

import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.EmailWithAttachment;
import com.jsp.boot_email.dto.MultipleEmail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	JavaMailSender sender;

	public void SimpleMailMessage(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getBody());
		message.setFrom("gowrisankar2223@gmail.com");
		sender.send(message);
	}

	public void multipleMailMessage(MultipleEmail email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getBody());
		message.setFrom("gowrisankar2223@gmail.com");
		sender.send(message);

	}

	public void sendEmailWithAttachment(MultipleEmail email) throws MessagingException {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper messages = new MimeMessageHelper(message, true);

		messages.setTo(email.getTo());
		messages.setSubject(email.getSubject());
		messages.setText(email.getBody());
		FileSystemResource file = new FileSystemResource(new File("download 1.jpeg"));
		messages.addAttachment("demo.jpeg", file);

		sender.send(message);
	}
	
	public void sendHtmlEmail(MultipleEmail email) throws AddressException, MessagingException {
		MimeMessage message = sender.createMimeMessage();

	    message.setFrom(new InternetAddress("gowrisankar2223@gmail.com"));
	    for (String emails : email.getTo()) {
		    message.setRecipients(MimeMessage.RecipientType.TO,emails );

		}
	    message.setSubject("Test email from Spring");
	    String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
	                         "<p>It can contain <strong>HTML</strong> content.</p>";
	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    sender.send(message);
	}

	public void sendEmailWithAttachmentForm(EmailWithAttachment email) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper messages = new MimeMessageHelper(message, true);

		messages.setTo(email.getTo());
		messages.setSubject(email.getSubject());
		messages.setText(email.getBody());
		FileSystemResource file = new FileSystemResource(email.getAttachment());
		messages.addAttachment(file.getFilename(), file);

		sender.send(message);
	}
}
