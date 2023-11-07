package com.example.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.todoapp.models.TodoItem;
import com.example.todoapp.services.todoItemService;
import jakarta.validation.Valid;

@Controller
public class TodoController {
  @Autowired
  private todoItemService todoItemService;

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("todoItems", todoItemService.getAll());
    return modelAndView;
  }

  @GetMapping("/delete/{id}")
  public String deleteTodo(@PathVariable("id") Long id, Model model) {
    TodoItem todoItem = todoItemService.getById(id).orElseThrow(() -> new IllegalArgumentException("Todo Item id:" + id + "not found"));

    todoItemService.delete(todoItem);
    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") Long id, Model model) {
      TodoItem todoItem = todoItemService.getById(id).orElseThrow(() -> new IllegalArgumentException("Todo Item id:" + id + "not found"));

      model.addAttribute("todo", todoItem);
      return "edit_todo";
  }

  @PostMapping("/todo/{id}")
  public String update(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
      TodoItem item = todoItemService.getById(id).orElseThrow(() -> new IllegalArgumentException("Todo Item id:" + id + "not found"));
      item.setStatus(todoItem.getStatus());
      item.setDeskripsi(todoItem.getDeskripsi());

      todoItemService.save(item);
      return "redirect:/";
  }
}
