package com.example.todo.controller;

import com.example.todo.repository.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> getAllToDos() {
        return new ResponseEntity<>(toDoService.getAllToDos(), HttpStatus.OK);
    }
}
