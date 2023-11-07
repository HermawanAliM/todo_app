package com.example.todoapp.models;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name="todo_items")
public class TodoItem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String deskripsi;
  private Boolean status;
  private Instant dibuat;

  @Override
  public String toString() {
    return String.format("todoItem{id=%d, deskripsi='%s', status='%s', dibuat='%s'}",
    id, deskripsi, status, dibuat);
  }

}
