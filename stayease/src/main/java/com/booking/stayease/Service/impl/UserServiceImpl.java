package com.booking.stayease.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.booking.stayease.Repository.UserRepository;
import com.booking.stayease.Service.UserService;
import com.booking.stayease.exception.UsernameNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetailsService userDetailsService(){
        return new  UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username) {
            return userRepository.findByEmail(username)
            .orElseThrow(()-> new UsernameNotFoundException("User not found"));
            
        }
    };
}
    
}
