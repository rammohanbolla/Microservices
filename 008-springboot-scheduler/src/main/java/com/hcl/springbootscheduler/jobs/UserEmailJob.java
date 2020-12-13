package com.hcl.springbootscheduler.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserEmailJob {

	@Autowired
	public JavaMailSender emailSender;

	@Scheduled(fixedRate = 60000)
	public void triggerUserEmails() {
		System.out.println("Hello job1...!!!");
		try{
			sendMail();
			System.out.println("Email sent successfully...");
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public void sendMail() throws Exception{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("uppari.santhosh.kumar@gmail.com");
		message.setSubject("This is subject");
		message.setText("This is body of the mail");
		emailSender.send(message);
	}

}
