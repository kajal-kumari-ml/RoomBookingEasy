package com.booking.stayease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.stayease.Service.AuthenticationService;
import com.booking.stayease.dto.RefreshTokenRequest;
import com.booking.stayease.dto.SignInRequest;
import com.booking.stayease.dto.SignUpRequest;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationContoller {

    @Autowired
    private AuthenticationService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest user) {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInRequest user) {
        return new ResponseEntity<>(userService.loginInUser(user), HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody  RefreshTokenRequest refreshToken) {
        return new ResponseEntity<>(userService.refreshToken(refreshToken), HttpStatus.OK);
    }
    
}
