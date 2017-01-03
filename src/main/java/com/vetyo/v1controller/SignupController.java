package com.vetyo.v1controller;

import com.vetyo.dto.UserRepository;
import com.vetyo.model.User;
import com.vetyo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1")
@RestController
public class SignupController {

    @Autowired
    SignupService signupService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> signup(@RequestBody User user){
           return signupService.signup(user);

    }
}
