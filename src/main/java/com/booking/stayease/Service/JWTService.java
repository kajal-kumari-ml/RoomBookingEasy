package com.booking.stayease.Service;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String extractUsername(String token);

    String generateToken(UserDetails userDetails);

    public boolean isTokenValis(String token, UserDetails userDetails);

    public String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails);

}
