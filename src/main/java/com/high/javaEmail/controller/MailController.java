package com.high.javaEmail.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.high.javaEmail.model.BodyMessage;
import com.high.javaEmail.service.Sendler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.cloud.stream.messaging.Sink.INPUT;

@EnableBinding(Sink.class)
public class MailController {
    @Autowired
    Sendler sendler;
    private ObjectMapper mapper = new ObjectMapper();

    @StreamListener(value = INPUT, condition = "headers['email']=='email'")
    public void sendMail(String jsonBody) throws IOException {

        BodyMessage body = mapper.readValue(jsonBody, new TypeReference<BodyMessage>() {
        });
        System.out.println(body);
        System.out.println("------------");
        sendler.sendMail(body);
    }


}
