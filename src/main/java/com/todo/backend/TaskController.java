package com.todo.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController // Ce composant est un "contrôleur" web
@RequestMapping("/api") // Toutes les routes commencent par /api
public class TaskController {
    public List<Task> tasks= new ArrayList<>();

    public TaskController(){
        // Initialisation de quelques tâches pour la démonstration
        tasks.add(new Task(1L, "Apprendre Java", "Comprendre les bases de Java et Spring Boot"));
        tasks.add(new Task(2L, "Faire une to-do", "Comprendre une API rest pour gerer une to-do"));
        tasks.add(new Task(3L, "Lier JavaScript", "Gerer Javascript en front"));
    }

    @GetMapping("/tasks") // Cette méthode répond à GET /api/test
    public List<Task> getAllTasks() {
        return tasks;
    }


    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task newTask) {
    // Simule l'attribution d'un ID (auto-incrément)
        long newId = tasks.size() + 1;
        newTask.setId(newId);
        newTask.setCreatedAt(java.time.LocalDateTime.now());
        tasks.add(newTask);
        return newTask;
}
}