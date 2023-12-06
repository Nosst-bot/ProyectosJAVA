package com.restwebservice.todo.mytodoapp.service;

import com.restwebservice.todo.mytodoapp.model.Todo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TodoHardcodedService {

    private static final List<Todo> todoList = new ArrayList<>();
    private static Long idCounter = 0L;
    static {
        todoList.add(new Todo(++idCounter, "nosst-bot", "Learn to Dance", new Date(), false));
        todoList.add(new Todo(++idCounter, "nosst-bot", "Learn about Microservices", new Date(), false));
        todoList.add(new Todo(++idCounter, "nosst-bot", "Learn about Angular", new Date(), false));
    }

    public List<Todo> findAll(){
        return todoList;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todoList.add(todo);
        } else {
            deleteById(todo.getId());
            todoList.add(todo);
        }
        return todo;
    }

    public Todo deleteById(Long id) {
        Todo todo = findById(id);

        if (todo==null) return null;

        if (todoList.remove(todo)) return todo;

        return null;
    }

    public Todo findById(long id) {
        for (Todo todo: todoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }

        return null;
    }

}
