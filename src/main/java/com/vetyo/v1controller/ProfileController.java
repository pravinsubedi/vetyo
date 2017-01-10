package com.vetyo.v1controller;

import com.vetyo.model.Ad;
import com.vetyo.model.User;
import com.vetyo.service.AdService;
import com.vetyo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Admin on 1/5/2017.
 */
@RestController
@RequestMapping("/v1")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "/profile/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> getProfile(@PathVariable Long id){
        return profileService.getProfile(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/profile/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<User> updateProfile(@PathVariable Long id,@RequestBody User user){
        return profileService.updateProfile(id,user);
    }
    @RequestMapping(value = "/profile/{id}/ad",method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> postAd(@PathVariable Long id,@RequestBody User user){
        return profileService.postAd(id,user);
    }
    @RequestMapping(value = "/profile/{id}/ad",method = RequestMethod.GET)
    public ResponseEntity<User> getAd(@PathVariable Long id){
        return profileService.getAd(id);
    }
}
