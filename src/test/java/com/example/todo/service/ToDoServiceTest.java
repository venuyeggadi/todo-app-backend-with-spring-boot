package com.example.todo.service;

import com.example.todo.repository.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ToDoServiceTest {

    @Mock
    ToDoRepository toDoRepository;

    @InjectMocks
    ToDoService toDoService;

    @Test
    void shouldGetAllToDosFromToDoRepository() {
        List<ToDo> toDoList = new ArrayList<>();
        toDoList.add(new ToDo(1L, "first task", false));
        toDoList.add(new ToDo(2L, "second task", false));
        when(toDoRepository.findAll()).thenReturn(toDoList);

        List<ToDo> actualToDoList = toDoService.getAllToDos();

        for (int i = 0; i < actualToDoList.size(); i++) {
            assertThat(actualToDoList.get(i).getId(), equalTo(toDoList.get(i).getId()));
            assertThat(actualToDoList.get(i).getDescription(), equalTo(toDoList.get(i).getDescription()));
            assertThat(actualToDoList.get(i).isCompleted(), equalTo(toDoList.get(i).isCompleted()));
        }
    }
}