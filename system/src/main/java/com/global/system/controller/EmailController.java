package com.global.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.system.service.EmailService;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(@RequestParam("toMail")String toMail,
                      @RequestParam("subject")String subject,
                      @RequestParam("message")String msg){
                        
                        
                   return emailService.sendMail(toMail, subject, msg);
                        
                        
                      }
    
}
