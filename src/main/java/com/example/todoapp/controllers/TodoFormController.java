package com.example.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.todoapp.models.TodoItem;
import com.example.todoapp.services.todoItemService;

import jakarta.validation.Valid;

@Controller
public class TodoFormController {

  @Autowired
  private todoItemService todoItemService;

  @GetMapping("/buat-todo")
  public String tampilBuatForm(TodoItem todoItem) {
    return "tambah_todo";
  }

  @PostMapping("/todo")
  public String buatTodoItem( @Valid TodoItem todoItem, BindingResult result, Model model) {
    TodoItem item = new TodoItem();
    item.setDeskripsi(todoItem.getDeskripsi());
    item.setStatus(todoItem.getStatus());
    todoItemService.save(todoItem);

    return "redirect:/";
  }
}
