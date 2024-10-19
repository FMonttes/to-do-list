package com.sec.sec.service;

import com.sec.sec.entitites.Task;
import com.sec.sec.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(Long id){
        Optional<Task> obj = taskRepository.findById(id);
        return obj.get();
    }
}
