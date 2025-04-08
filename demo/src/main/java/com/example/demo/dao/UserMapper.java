package com.example.demo.dao;


import com.example.demo.dto.SignupUser;
import com.example.demo.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int countByUsernameAndPassword(String username, String password);
    void insertUser(SignupUser signupUser);
}
