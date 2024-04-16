package com.booking.stayease.Service;


import com.booking.stayease.Entity.User;
import com.booking.stayease.dto.JwtResponse;
import com.booking.stayease.dto.RefreshTokenRequest;
import com.booking.stayease.dto.SignInRequest;
import com.booking.stayease.dto.SignUpRequest;

public interface AuthenticationService {

        public User registerUser(SignUpRequest user) ;
            public JwtResponse loginInUser(SignInRequest user);
            public JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    
}
