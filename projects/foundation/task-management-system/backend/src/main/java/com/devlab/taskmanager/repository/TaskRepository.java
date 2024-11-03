package com.devlab.taskmanager.repository;

import com.devlab.taskmanager.model.Task;
import com.devlab.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
