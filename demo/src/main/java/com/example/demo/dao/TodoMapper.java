package com.example.demo.dao;

import com.example.demo.dto.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TodoMapper {
    List<Todo> todoList(String username);
    void insertTodo(String username,String content);
    void toggle(Map<String,Object> map);
    void delete(String username,Long id);
}
