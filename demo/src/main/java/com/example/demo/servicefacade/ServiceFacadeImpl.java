package com.example.demo.servicefacade;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.SignupUser;
import com.example.demo.dto.User;
import com.example.demo.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceFacadeImpl implements ServiceFacade{

    @Autowired
    UserMapper userMapper;
    @Autowired
    JwtUtil jwtUtil;

   public String login(String username, String password){
       int count = userMapper.countByUsernameAndPassword(username, password);
       // 2. 유효할 경우 → 토큰 발급
       if (count > 0) {
           return jwtUtil.generateToken(username);
       }
       // 3. 실패 → null 리턴
       return null;
    }

    public void insertUser(SignupUser signupUser){
            userMapper.insertUser(signupUser);
    }
}
