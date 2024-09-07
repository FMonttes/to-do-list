package com.felipe.autentication.service;

import com.felipe.autentication.exception.EntityNotFoundException;
import com.felipe.autentication.exception.UseEntityException;
import com.felipe.autentication.model.Task;
import com.felipe.autentication.model.User;
import com.felipe.autentication.repository.TaskRepository;
import com.felipe.autentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public User save(User user){
        Long taskId = user.getTask().getId();
        Task task = taskRepository.findById(taskId).
                orElseThrow(() -> new EntityNotFoundException(
                        String.format("deu pepi")
                ));
        user.setTask(task);
        return userRepository.save(user);
    }

    public void remove(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException(
                    String.format("There's no user with code %d", id));
        }
        userRepository.deleteById(id);
    }
}
