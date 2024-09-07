package com.felipe.autentication.controller;

import com.felipe.autentication.exception.EntityNotFoundException;
import com.felipe.autentication.model.User;
import com.felipe.autentication.repository.UserRepository;
import com.felipe.autentication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user){

        try {
            user = userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(user);
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {

        Optional<User> actualUser = userRepository.findById(id);
        try {
            if (actualUser.isPresent()) {
                BeanUtils.copyProperties(user, actualUser.get(), "id");
                User newUser = userService.save(actualUser.get());
                return ResponseEntity.ok(newUser);
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try {
            userService.remove(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
