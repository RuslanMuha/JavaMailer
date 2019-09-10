package com.high.javaEmail.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class GenerateHTML {

    @Autowired

    private TemplateEngine templateEngine;

    public String generateMailHtml(Object links) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("links", links);
        final String templateFileName = "email";
        return this.templateEngine.process(templateFileName, new Context(Locale.getDefault(), variables));

    }
}
