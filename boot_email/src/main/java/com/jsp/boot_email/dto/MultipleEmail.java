package com.jsp.boot_email.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
public class MultipleEmail {
	private String []to;
	private String subject;
	private String body;
}
