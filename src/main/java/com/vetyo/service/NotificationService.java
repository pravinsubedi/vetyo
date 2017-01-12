package com.vetyo.service;

/**
 * Created by Admin on 1/12/2017.
 */

import com.vetyo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 1/12/2017.
 */
@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    public void sendNotification(User user) throws MailException{
        //send email;
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("mepravinsubedi@gmail.com");
        mail.setSubject("spring boot test");
        mail.setText("this is a new mzessage");

        javaMailSender.send(mail);
    }
}
