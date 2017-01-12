package com.vetyo.v1controller;

import com.vetyo.dto.UserRepository;
import com.vetyo.model.User;
import com.vetyo.service.NotificationService;
import com.vetyo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/v1")
@RestController
public class SignupController {

    @Autowired
    SignupService signupService;
    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> signup(@Valid @RequestBody User user){
            try{
                notificationService.sendNotification(user);
            }
            catch (MailException e){
                System.out.println(e);
            }

           return signupService.signup(user);

    }
}
