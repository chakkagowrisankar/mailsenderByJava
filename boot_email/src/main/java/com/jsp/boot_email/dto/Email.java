package com.jsp.boot_email.dto;

import lombok.Data;

@Data
public class Email {
	private String to;
	private String subject;
	private String body;
}
