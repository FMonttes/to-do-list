package com.sec.sec.config;

import com.sec.sec.entitites.Task;
import com.sec.sec.entitites.User;
import com.sec.sec.repositories.TaskRepository;
import com.sec.sec.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TestConfig(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Task task1 = new Task(null ,"ingles");
        Task task2 = new Task(null ,"filosofia");
        Task task3 = new Task(null ,"matemagica");
        Task task4 = new Task(null ,"fisica");

        User user1 = new User(null ,"felipe");
        User user2 = new User(null ,"mariana");
        User user3 = new User(null ,"gustavo");

        taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4));

        user1.getTasks().add(task1);
        user1.getTasks().add(task2);
        user1.getTasks().add(task3);
        user1.getTasks().add(task4);
        user2.getTasks().add(task2);
        user3.getTasks().add(task3);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

    }
}
