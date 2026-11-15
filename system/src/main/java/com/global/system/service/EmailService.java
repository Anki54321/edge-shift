package com.global.system.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public  String sendMail(String toMail,String subject,String message1) {
        String to = toMail.trim();
        String from = "shyamjava2020@gmail.com";
        String host = "smtp.gmail.com";
        String msg=null;
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vertilinkjava@gmail.com", "ptwydgoclmavfpah");
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(message1);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
            msg="Sent message successfully";
        } catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println("failed to send message");
            msg="failed to send message";
        }finally {
			
		}
		return msg;

    }
    
}
