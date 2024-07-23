package com.jsp.boot_email.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.EmailWithAttachment;
import com.jsp.boot_email.dto.MultipleEmail;
import com.jsp.boot_email.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	EmailService service;
	@GetMapping("/message")
	public String m1() {
		return "hai";
	}
	@PostMapping("/send")
	public String simpleMailMessage(@RequestBody Email email) {
		try {
			service.SimpleMailMessage(email);
			return "message send sucessfully";
		}catch(Exception e) {
			return "Internal issue try again";
		}
	}
	@PostMapping("/sends")
	public String multipleMailMessage(@RequestBody MultipleEmail email) {
		try {
			service.multipleMailMessage(email);
			return "message send sucessfully";
		}catch(Exception e) {
			return "Internal issue try again";
		}
	}
	@PostMapping("/sendEmailWithAttachment")
	public String sendEmailWithAttachment(@RequestBody MultipleEmail email) {
		try {
			service.sendEmailWithAttachment(email);
			return "message send sucessfully";
		}catch(Exception e) {
			return "Internal issue try again";
		}
	}
	@PostMapping("/sendEmailWithAttachmentForm")
	public String sendEmailWithAttachment(@RequestBody EmailWithAttachment email) {
		try {
			service.sendEmailWithAttachmentForm(email);
			return "message send sucessfully";
		}catch(Exception e) {
			return "Internal issue try again";
		}
	}
	@PostMapping("/sendEmailHtml")
	public String sendHTMLEmails (@RequestBody MultipleEmail email) {
		try {
			service.sendHtmlEmail(email);
			return "message send sucessfully";
		}catch(Exception e) {
			return "Internal issue try again";
		}
	}
}
