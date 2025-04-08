package com.example.demo.dto;

import lombok.Data;

@Data
public class SignupUser {
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
}
