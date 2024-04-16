package com.booking.stayease.Service.impl;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.booking.stayease.Entity.User;
import com.booking.stayease.Enums.Role;
import com.booking.stayease.Repository.UserRepository;
import com.booking.stayease.Service.AuthenticationService;
import com.booking.stayease.Service.JWTService;
import com.booking.stayease.dto.JwtResponse;
import com.booking.stayease.dto.RefreshTokenRequest;
import com.booking.stayease.dto.SignInRequest;
import com.booking.stayease.dto.SignUpRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JWTService jwtService;

    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder,JWTService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public User registerUser(SignUpRequest user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getFirstName() + " " + user.getLastName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        if(user.getRole()==null){
            newUser.setRole(Role.CUSTOMER);
        }else{
            newUser.setRole(user.getRole().equals("ADMIN") ? Role.ADMIN : Role.HOTEL_MANAGER);
        
        }
        return userRepository.save(newUser);
    }


    public JwtResponse loginInUser(SignInRequest user){
            Optional<User> userOptional = userRepository.findByEmail(user.getUsername());
            if (!passwordEncoder.matches(user.getPassword(), userOptional.get().getPassword())) {
                throw new UsernameNotFoundException("User not found");
            }
            if (!userOptional.isPresent()) {
                throw new UsernameNotFoundException("User not found");
            }
            String token = jwtService.generateToken(userOptional.get());
            String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), userOptional.get());

            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.setToken(token);
            jwtResponse.setRefreshToken(refreshToken);
            return jwtResponse;

    }

    public JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String username = jwtService.extractUsername(refreshTokenRequest.getToken());
        User user = userRepository.findByEmail(username).get();
        if(jwtService.isTokenValis(refreshTokenRequest.getToken(),user)){
            String newToken = jwtService.generateToken(user);

            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.setToken(newToken);
            jwtResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtResponse;
        }
        throw new UsernameNotFoundException("User not found");
    }

    
}
