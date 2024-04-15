package com.booking.stayease.dto;

public class SignInRequest {

    private Long id;
    private String username;
    private String password;

    public SignInRequest() {
    }

    public SignInRequest(Long id,String username, String password) {
        this.id=id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
