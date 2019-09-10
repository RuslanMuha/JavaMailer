package com.high.javaEmail.service;

import com.high.javaEmail.config.GenerateHTML;
import com.high.javaEmail.model.BodyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class SendlerImpl implements Sendler {

    private static final String VACANCY = "Vacancy";

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private GenerateHTML template;

    @Override
    public void sendMail(BodyMessage chanel) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setText(template.generateMailHtml(chanel.getBody()), true);
            helper.addInline("image", new ClassPathResource("templates/hig.png"));
            helper.setSubject(VACANCY);
            helper.setTo(chanel.getNotifications().get("email"));
            helper.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        emailSender.send(message);
    }
}