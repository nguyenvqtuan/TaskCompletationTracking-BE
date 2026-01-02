package com.example.tasktracker.application.services;

import com.example.tasktracker.domain.model.Task;
import com.example.tasktracker.domain.model.TaskStatus;
import com.example.tasktracker.domain.repository.TaskRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetTasksService {

  private final TaskRepository taskRepository;

  public List<Task> getAll() {
    return taskRepository.findAll();
  }

  public Optional<Task> getById(UUID id) {
    return taskRepository.findById(id);
  }

  public List<Task> getByStatus(TaskStatus status) {
    return taskRepository.findByStatus(status);
  }
}
