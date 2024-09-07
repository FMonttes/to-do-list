package com.felipe.autentication.service;

import com.felipe.autentication.exception.EntityNotFoundException;
import com.felipe.autentication.exception.UseEntityException;
import com.felipe.autentication.model.Task;
import com.felipe.autentication.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;
    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void remove(Long id){
        if(!taskRepository.existsById(id)) {
            throw new EntityNotFoundException(
                    String.format("there's no task code of number %d ", id));
        }
            try {
                taskRepository.deleteById(id);
            }catch (DataIntegrityViolationException e){
                throw new UseEntityException(
                        String.format("task code %d cannot be removed cause is already in use", id)
                );
            }
    }
}
