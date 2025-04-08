package com.example.demo.controller;


import com.example.demo.dto.SignupUser;
import com.example.demo.dto.User;
import com.example.demo.servicefacade.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

     @Autowired
     ServiceFacade serviceFacadeImpl;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String token = serviceFacadeImpl.login(user.getUsername(), user.getPassword());

        if (token != null) {
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }
    @PostMapping("/signup")
    public void signup(@RequestBody SignupUser signupUser) {
        serviceFacadeImpl.insertUser(signupUser);
    }

}
