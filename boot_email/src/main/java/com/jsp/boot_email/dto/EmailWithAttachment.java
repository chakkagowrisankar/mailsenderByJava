package com.jsp.boot_email.dto;

import lombok.Data;

@Data
public class EmailWithAttachment {
	private String[] to;
	private String subject;
	private String body; 
	private String attachment;
}
