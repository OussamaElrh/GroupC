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

public class Mail {

	//this method generates a random value with a length of 8 chars mentioned in the allChars var
	public static String randomAlphaNumeric() {
		String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		int count = 8;
		while (count-- != 0) {
			int character = (int)(Math.random()*allChars.length());
			builder.append(allChars.charAt(character));
		}
		return builder.toString();
	}
	
	//this method encrypte gen
	public static String MD5(String m){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			String pass = new BigInteger(1,md5.digest(m.getBytes())).toString(32);
			return pass;
		} catch (Exception e) {
			return null;
		}

	}
	
	public static boolean sendEmail(String destMail,String userPassword){		
		final String rootMail = "artizoone@gmail.com";
		final String rootpassword =  "artizone2017";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(rootMail, rootpassword);
			}
		  });	
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(rootMail));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destMail));
			message.setSubject("MQL account activation");
			
			message.setContent("<h2> voila votre mot de passe : " + userPassword + "</h2>", "text/html");
			Transport.send(message);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
}
