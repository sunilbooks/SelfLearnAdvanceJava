package com.sunilbooks.mail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * @version 1.0
 * @since 01 June 2015
 * @author Sunil Sahu
 * @Copyright (c) Sunil Sahu
 * @url www.sunilbooks.com
 */
public class SendMail {

	//SMTP server domain name or ip address
	private static final String SMTP_SERVER = "smtp.gmail.com";

	//SMTP server port number 
	private static final int SMTP_PORT = 465;
	
	//SMTP server login id
	private static final String LOGIN = "sunil.sahu@nenosystems.com";

	//SMTP server password 
	private static final String PASSWORD = "Linus1747";

	private static Properties props = new Properties();

	static {
		// Set SMTP server configuration properties
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", SMTP_SERVER);
		props.put("mail.smtps.port", SMTP_PORT);
		props.put("mail.smtps.auth", "true");
	}

	private static String from = "sunil.sahu@nenosystems.com";
	private static String to = "sunilsahu007@gmail.com";

	public static void main(String[] args) throws Exception {

		// sendTextEmail();
		//sendHtmlEmail();
		sendAttachedFile();

	}

	public static void sendTextEmail() throws Exception {

		String subject = "My first email from JavaMail API";
		String msg = "Hi, this is message from Sunil Sahu";

		// Initialize Session object
		Session session = Session.getDefaultInstance(props);
		//session.setDebug(true); // see debug messages

		// Create message to send
		MimeMessage message = new MimeMessage(session);

		// From address
		message.setFrom(new InternetAddress(from));
		// To address
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject); // Subject

		// Set message and its mime type
		// message.setContent(msg, "text/plain"); // Content type of message
		message.setText(msg);

		// Get transport to send an email
		Transport transport = session.getTransport();
		// Connect to server
		transport.connect(SMTP_SERVER, SMTP_PORT, LOGIN, PASSWORD);
		// Send message
		Address[] toAdds = message.getRecipients(Message.RecipientType.TO);
		transport.sendMessage(message, toAdds);
		// close connection
		transport.close();
	}

	/**
	 * Sends HTML text in email
	 * 
	 * @throws Exception
	 */
	public static void sendHtmlEmail() throws Exception {

		String subject = "My first email from JavaMail API";
		String msg = "<H1>Hi, this is message from Sunil Sahu</H1>";

		// Initialize Session object
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); // see debug messages

		// Create message to send
		MimeMessage message = new MimeMessage(session);

		// From address
		message.setFrom(new InternetAddress(from));
		// To address
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject); // Subject

		// Set message and its mime type
		message.setContent(msg, "text/html"); // Content type of message

		// Get transport to send an email
		Transport transport = session.getTransport();
		// Connect to server
		transport.connect(SMTP_SERVER, SMTP_PORT, LOGIN, PASSWORD);
		// Send message
		Address[] toAdds = message.getRecipients(Message.RecipientType.TO);
		transport.sendMessage(message, toAdds);
		// close connection
		transport.close();
	}

	/**
	 * Send file as an attachement in email
	 * 
	 * @throws Exception
	 */
	public static void sendAttachedFile() throws Exception {

		String subject = "My first email with file attachment";
		String msg = "<H1>Hi, see the file attached </H1>";

		// Initialize Session object
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); // see debug messages

		// Create message to send
		MimeMessage message = new MimeMessage(session);

		// From address
		message.setFrom(new InternetAddress(from));
		// To address
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject); // Subject

		// Create a multipar message
		Multipart multipart = new MimeMultipart();

		// Create the message part
		MimeBodyPart htmlBodyPart = new MimeBodyPart();
		htmlBodyPart.setContent(msg, "text/html");
		multipart.addBodyPart(htmlBodyPart);

		// Part two is attachment
		MimeBodyPart fileBodyPart = new MimeBodyPart();
		String filename = "g:\\test.txt";
		fileBodyPart.attachFile(filename);
		multipart.addBodyPart(fileBodyPart);

		// Set message and its mime type
		message.setContent(multipart); // Content type of message

		// Get transport to send an email
		Transport transport = session.getTransport();
		// Connect to server
		transport.connect(SMTP_SERVER, SMTP_PORT, LOGIN, PASSWORD);
		// Send message
		Address[] toAdds = message.getRecipients(Message.RecipientType.TO);
		transport.sendMessage(message, toAdds);
		// close connection
		transport.close();
	}

}
