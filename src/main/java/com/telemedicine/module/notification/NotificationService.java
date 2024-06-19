package com.telemedicine.module.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {
    @Autowired
   private EmailSenderService emailSenderService;

    public void sendEmail(String toEmail,
                          String body,
                          String subject){
        try {
            emailSenderService.sendMailWithAttachment(toEmail, body, subject);
        }
        catch (Exception e){
            log.info("exception catch while sending email");
        }
    }
}
