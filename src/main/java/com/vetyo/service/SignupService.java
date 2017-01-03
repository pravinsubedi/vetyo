package com.vetyo.service;

import com.vetyo.dto.UserRepository;
import com.vetyo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<User> signup(User user){
        userRepository.save(user);
        return new ResponseEntity<User>(userRepository.findOne(user.getId()),HttpStatus.CREATED);
    }
}