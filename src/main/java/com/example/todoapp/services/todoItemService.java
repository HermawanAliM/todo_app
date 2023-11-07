package com.example.todoapp.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.models.TodoItem;
import com.example.todoapp.repositories.todoItemRepository;

@Service
public class todoItemService {
  @Autowired
  private todoItemRepository todoItemRepository;

  public Iterable<TodoItem> getAll() {
    return todoItemRepository.findAll();
  }

  public Optional<TodoItem> getById(Long id) {
    return todoItemRepository.findById(id);
  }

  public TodoItem save(TodoItem todoItem) {
    if (todoItem.getId() == null) {
      todoItem.setDibuat(Instant.now());
    }

    return todoItemRepository.save(todoItem);
  } 

  public void delete(TodoItem todoItem) {
    todoItemRepository.delete(todoItem);
  }
}
