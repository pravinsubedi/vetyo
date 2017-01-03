package com.vetyo.service;

import com.vetyo.dto.UserRepository;
import com.vetyo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    UserRepository userRepository;

    public String signup(User user){
        userRepository.save(user);
        return "user saved";
    }
}