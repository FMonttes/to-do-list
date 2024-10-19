package com.sec.sec.controller;

import com.sec.sec.entitites.Task;
import com.sec.sec.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    List<Task> listAll(){
        return taskService.findAll();
    }
    @GetMapping("/{id}")
    ResponseEntity<Task> findById(@PathVariable Long id){
        Task task = taskService.findById(id);
        return ResponseEntity.ok().body(task);
    }
}
