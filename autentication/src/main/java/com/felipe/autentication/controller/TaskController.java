package com.felipe.autentication.controller;

import com.felipe.autentication.exception.EntityNotFoundException;
import com.felipe.autentication.exception.UseEntityException;
import com.felipe.autentication.model.Task;
import com.felipe.autentication.repository.TaskRepository;
import com.felipe.autentication.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    public final TaskRepository taskRepository;
    public final TaskService taskService;

    @GetMapping
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Task task,
                                    @PathVariable Long id) {

        Optional<Task> taskActual = taskRepository.findById(id);
        if (taskActual.isPresent()) {
            BeanUtils.copyProperties(task, taskActual.get(), "id");
            Task newTask = taskService.save(taskActual.get());
            return ResponseEntity.ok(taskActual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            taskService.remove(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (UseEntityException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
