package com.example.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todoapp.models.TodoItem;

@Repository
public interface todoItemRepository extends JpaRepository<TodoItem, Long> {


  
}
