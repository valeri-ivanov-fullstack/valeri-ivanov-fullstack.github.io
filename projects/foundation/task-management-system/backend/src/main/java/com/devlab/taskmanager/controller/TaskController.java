package com.devlab.taskmanager.controller;

import com.devlab.taskmanager.model.Task;
import com.devlab.taskmanager.model.User;
import com.devlab.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, Principal principal) {
        // Assume user is authenticated and retrieved by username
        User user = null; // TODO Retrieve authenticated user from principal
        return new ResponseEntity<>(taskService.createTask(task, user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Task> getUserTasks(Principal principal) {
        User user = null;  // TODO Retrieve authenticated user from principal
        return taskService.getTasksByUser(user);
    }
}
