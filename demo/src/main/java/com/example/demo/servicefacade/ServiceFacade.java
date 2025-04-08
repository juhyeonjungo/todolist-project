package com.example.demo.servicefacade;

import com.example.demo.dto.SignupUser;
import com.example.demo.dto.User;

import java.util.List;

public interface ServiceFacade {
       String login(String username, String password);
       void insertUser(SignupUser SignupUser);
}
