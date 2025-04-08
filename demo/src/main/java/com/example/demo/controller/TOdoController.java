package com.example.demo.controller;


import com.example.demo.dto.Todo;
import com.example.demo.servicefacade.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.jwt.JwtUtil;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/todos")
public class TOdoController {

    @Autowired
    TodoService todoService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping
    public List<Todo> getTodoList(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.substring(7); // "Bearer " 제거
        String username = jwtUtil.getUsername(token); //
        return todoService.getTodoList(username);
    }

    @PostMapping("/add")
    public void addTodoList(@RequestBody Todo todo, @RequestHeader("Authorization") String authHeader){
        String token = authHeader.substring(7);
        String username = jwtUtil.getUsername(token);
        todoService.insertTodo(username, todo);
    }
    // await $axios.put(`/todos/toggle/${id}`);

    @PutMapping("/toggle/{id}")
    public void toggle(@PathVariable int id, @RequestHeader("Authorization") String authHeader){
        String token = authHeader.substring(7);
        String username = jwtUtil.getUsername(token);
        todoService.toggle(username,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodos(@PathVariable Long id, @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        String username = jwtUtil.getUsername(token);
        try {
            todoService.deleteTodos(username, id); // 삭제 작업
            return ResponseEntity.ok("삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 실패");
        }
    }
}
