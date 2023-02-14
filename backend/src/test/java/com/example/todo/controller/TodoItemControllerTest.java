package com.example.todo.controller;


import com.example.todo.model.TodoItem;
import com.example.todo.repository.TodoItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

public class TodoItemControllerTest {

  private MockMvc mockMvc;

  @Mock
  private TodoItemRepository todoItemRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(new TodoItemController(todoItemRepository)).build();
  }

  @Test
  public void testGetAllTodoItems() throws Exception {
    List<TodoItem> todoItems = new ArrayList<>();
    todoItems.add(new TodoItem(1L, "Todo 1","Todo 1 Item content", false));
    todoItems.add(new TodoItem(2L, "Todo 2","Todo 2 Item content", false));

    when(todoItemRepository.findAll()).thenReturn(todoItems);

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/todos"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].title").value("Todo 1"))
            .andExpect(jsonPath("$[0].completed").value(false))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[1].title").value("Todo 2"))
            .andExpect(jsonPath("$[1].completed").value(false))
            .andDo(print())
            .andReturn();

    verify(todoItemRepository, times(1)).findAll();
  }

  // Add more test methods for other controller methods
}
