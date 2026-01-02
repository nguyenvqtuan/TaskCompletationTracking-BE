package com.example.tasktracker.domain.repository;

import com.example.tasktracker.domain.model.Task;
import com.example.tasktracker.domain.model.TaskStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(UUID id);
    List<Task> findAll();
    List<Task> findByStatus(TaskStatus status);
    void deleteById(UUID id);
}
