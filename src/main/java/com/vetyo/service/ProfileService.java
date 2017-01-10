package com.vetyo.service;

import com.vetyo.dto.UserRepository;
import com.vetyo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * Created by Admin on 1/5/2017.
 */
@Service
public class ProfileService {
    @Autowired
    UserRepository userRepository;
    public ResponseEntity<User> getProfile(Long id){
        return new ResponseEntity<User>(userRepository.findOne(id), HttpStatus.OK);
    }
    public ResponseEntity<User> updateProfile(Long id,User user){
        User user1=new User();
        user1=userRepository.findOne(id);
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setUsername(user.getUsername());
        user1.setAdmin(user.getAdmin());
        user1.setPno(user.getPno());
        userRepository.save(user1);
        return new ResponseEntity<User>(userRepository.findOne(id),HttpStatus.OK);
    }
    public ResponseEntity<User> postAd(Long id,User user){
        User user1=new User();
        user1=userRepository.findOne(id);
        user1.setAdList(user.getAdList());
        userRepository.save(user1);
        return new ResponseEntity<User>(userRepository.findOne(id),HttpStatus.OK);
    }
    public ResponseEntity<User> getAd(Long id){
        return new ResponseEntity<User>(userRepository.findOne(id),HttpStatus.OK);
    }
}
