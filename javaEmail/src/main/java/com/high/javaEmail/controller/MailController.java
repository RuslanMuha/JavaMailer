package com.high.javaEmail.controller;

import com.high.javaEmail.model.BodyMessage;
import com.high.javaEmail.service.Sendler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    Sendler sendler;

    @PostMapping("/notification/email/")
    public boolean sendMail(@RequestBody BodyMessage message){

        return sendler.sendMail(message);
    }


}
