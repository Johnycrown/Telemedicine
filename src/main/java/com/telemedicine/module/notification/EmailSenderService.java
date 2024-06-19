package com.telemedicine.module.notification;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMailWithAttachment(String toEmail,
                                       String body,
                                       String subject) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("arjungautam8877@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

       // mimeMessageHelper.addAttachment("data.xlsx", new ByteArrayResource(excelBytes));

        javaMailSender.send(mimeMessage);
        //System.out.printf("Mail with attachment sent successfully..");

    }
}
