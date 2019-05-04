//package com.high.javaEmail.mailSender;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import javax.mail.*;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMultipart;
//import java.io.IOException;
//
//
//public class EmailSender {
//
//    @Autowired
//    Environment env;
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//
////    public EmailSender(JavaMailSender javaMailSender) {
////        this.javaMailSender = javaMailSender;
////    }
//
//    public void sendSimpleEmail(String toEmail, String subject, String message) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(toEmail);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(message);
//        javaMailSender.send(mailMessage);
//    }
//
////public void  sendMimeEmail(String toEmail, String subject, String mess){
////
////        try {
////            Message message = javaMailSender.createMimeMessage();
////            message.setRecipients(Message.RecipientType.TO,
////                    InternetAddress.parse(toEmail));
////            message.setSubject(subject);
////
////            MimeBodyPart messageBodyPart = new MimeBodyPart();
////            messageBodyPart.setContent(mess, "text/plain");
////
////            Multipart multipart = new MimeMultipart();
////            multipart.addBodyPart(messageBodyPart);
////
////            // Attachment
//////            if (filename != null) {
//////                MimeBodyPart attachment = new MimeBodyPart();
////////                DataSource source = new FileDataSource(FILENAME);
////////                attachment.setDataHandler(new DataHandler(source));
////////                attachment.setFileName(source.getName());
//////                attachment.attachFile(filename);
//////                multipart.addBodyPart(attachment);
//////            }
////
//////            // Send the complete message parts
//////            message.setContent(multipart);
////
////            Transport.send(message);
////            System.out.println("Message to " + toEmail + " sent successfully.");
////        } catch (MessagingException e) {
////            throw new RuntimeException(e);
////        }
////}
//}
