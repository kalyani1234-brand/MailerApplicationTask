package com.example.demo.MailerApplication.service;

import java.io.File;
import java.io.FileWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	/*
	 * this is the service class
	 * the actual business logic is written here .
	 * The requests would be transfered from controller
	 * The service class do interaction with repository to executes the business logic 
	 */
	@Autowired
	 private JavaMailSender mailSender;
	    private SimpleMailMessage simpleMailMessage;
	    
	    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
	        this.simpleMailMessage = simpleMailMessage;
	    }

	    public void setMailSender(JavaMailSender mailSender) {
	    	/* 
	    	 * This setter method initiates the JavaMailSender object
	    	 */
	        this.mailSender = mailSender;
	    }
	    
	public void sendMailMethod(String toEmail, String body, String subject,String from,String attachments)
			throws MessagingException {
		/* 
		 * This method gets details from controller and sends mail
		 */
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper mimeMessagehelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessagehelper.setFrom(from);
		mimeMessagehelper.setTo(toEmail);
		mimeMessagehelper.setText(body);
		mimeMessagehelper.setSubject(subject);
		FileSystemResource filesystem = new FileSystemResource(new File(attachments));
		
		mimeMessagehelper.addAttachment(filesystem.getFilename(), filesystem);
		mailSender.send(mimeMessage);
		System.out.println("successfully sent");
		
		
	}
}

