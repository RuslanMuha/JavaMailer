package com.high.javaEmail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BodyMessage {

    private String [] toEmail;
    private String subject;
    private String message;

}
