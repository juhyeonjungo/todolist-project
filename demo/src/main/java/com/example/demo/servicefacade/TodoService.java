package com.example.demo.servicefacade;

import com.example.demo.dto.Todo;

import java.util.List;
import java.util.Map;

public interface TodoService {
    List<Todo> getTodoList(String username);
    void insertTodo(String username,Todo todo);
    void toggle(String username, int id);
    void deleteTodos(String username,Long id);
}
