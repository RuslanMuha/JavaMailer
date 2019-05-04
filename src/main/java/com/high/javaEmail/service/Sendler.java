package com.high.javaEmail.service;

import com.high.javaEmail.model.BodyMessage;

public interface Sendler {

     boolean sendMail(BodyMessage message);
}
