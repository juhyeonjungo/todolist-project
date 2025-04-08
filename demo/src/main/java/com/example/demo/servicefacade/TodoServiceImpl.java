package com.example.demo.servicefacade;

import com.example.demo.dao.TodoMapper;
import com.example.demo.dto.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoMapper todoMapper;

    @Override
    public List<Todo> getTodoList(String username){

        return  todoMapper.todoList(username);
    }

    @Override
    public void insertTodo(String username,Todo todo){
        String content=todo.getContent();
                 todoMapper.insertTodo(username,content);
    }

    @Override
    public void toggle(String username, int id){
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("id", id);
        todoMapper.toggle(params);

    }

    @Override
    public void deleteTodos(String username,Long id) {

            todoMapper.delete(username, id);

    }
}
