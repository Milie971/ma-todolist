package com.todo.backend;

import java.time.LocalDateTime;

public class Task {
  private Long id;
  private String title;
  private String description;
  private boolean completed;
  private LocalDateTime createdAt;

  public Task() {
    this.createdAt = LocalDateTime.now();
    this.completed = false;

}


  public Task(Long id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.createdAt = LocalDateTime.now();
    this.completed = false;
  }

     // Getters et Setters (obligatoires pour Spring)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  // public LocalDateTime getCreatedAt() {
  //   return createdAt;
  public LocalDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
  }










