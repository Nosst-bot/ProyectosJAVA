package com.restwebservice.todo.mytodoapp.controller;

import com.restwebservice.todo.mytodoapp.model.Todo;
import com.restwebservice.todo.mytodoapp.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class TodoController {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable Long id) {
        return todoHardcodedService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String username, @PathVariable Long id) {
        Todo todo = todoHardcodedService.deleteById(id);

        if (todo!=null) return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username,
            @PathVariable Long id,
            @RequestBody Todo todo
    ){
        Todo todoModified = todoHardcodedService.save(todo);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(
            @PathVariable String username,
            @RequestBody Todo todo
    ){
        todo.setId(0L);
        Todo createdTodo = todoHardcodedService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
