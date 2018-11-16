package org.mql.platform.tools.preregistration;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;


public class MailManager {
	@Autowired
	ConfigurableEnvironment conf;
	//a method to generates a random value composed from chars specified in the allChars var and with a length of 8 chars
	public String randomAlphaNumeric() {
		String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		int count = 8;
		while (count-- != 0) {
			int character = (int)(Math.random()*allChars.length());
			builder.append(allChars.charAt(character));
		}
		return builder.toString();
	}
	
	//a method to encrypt the generated password
	public String MD5(String m){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			String pass = new BigInteger(1,md5.digest(m.getBytes())).toString(32);
			return pass;
		} catch (Exception e) {
			return null;
		}

	}
	
	//method for sending the generated password to a student
	public boolean sendEmail(String destMail, String generatedPass){
		/*for 1&2 to work, you should create an VM arguments (rootMail & rootPassword) 
		*in which you specify the sender mail and password 
		*N.B: your email should have "Allow less secure apps" configured to yes (https://myaccount.google.com/lesssecureapps?pli=1)
		*/
		/*1*/final String rootMail = conf.getProperty("rootMail");
		/*2*/final String rootPassword = conf.getProperty("rootPassword");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(rootMail, rootPassword);
			}
		  });	
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(rootMail));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destMail));
			message.setSubject("MQL account password :");
			message.setContent("<h2>Salut, voilà votre mot de passe : " + generatedPass + "</h2>", "text/html");
			Transport.send(message);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
}
