package com.vetyo.security;

import com.sun.org.apache.xpath.internal.operations.String;
import com.vetyo.dto.UserRepository;
import com.vetyo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 1/9/2017.
 */
@Component
public class VetyoDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(java.lang.String username) throws UsernameNotFoundException{
        User user=userRepository.findByUsername(username);

        if (user==null){
            throw new UsernameNotFoundException(java.lang.String.format("user with username %s doesnt exist",username));
        }
        List<GrantedAuthority> authorities=new ArrayList<>();
        if(user.getAdmin()==true){
            authorities= AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        }
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
        return userDetails;
    }



}
