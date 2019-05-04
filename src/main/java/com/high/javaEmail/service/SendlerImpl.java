package com.high.javaEmail.service;

import com.high.javaEmail.model.BodyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendlerImpl implements Sendler {


    @Autowired
    Environment env;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendMail(BodyMessage email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email.getToEmail());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getMessage());
        try{
            javaMailSender.send(mailMessage);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
