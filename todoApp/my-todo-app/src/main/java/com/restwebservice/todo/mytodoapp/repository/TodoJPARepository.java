package com.restwebservice.todo.mytodoapp.repository;

import com.restwebservice.todo.mytodoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByUsername(String username);

}
