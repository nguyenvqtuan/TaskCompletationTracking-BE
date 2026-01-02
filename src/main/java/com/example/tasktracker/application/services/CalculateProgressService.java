package com.example.tasktracker.application.services;

import com.example.tasktracker.domain.model.Task;
import com.example.tasktracker.domain.model.TaskStatus;
import com.example.tasktracker.domain.repository.TaskRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculateProgressService {

  private final TaskRepository taskRepository;

  public double execute() {
    List<Task> tasks = taskRepository.findAll();
    if (tasks.isEmpty()) {
      return 0.0;
    }

    long completedCount = tasks.stream().filter(t -> t.getStatus() == TaskStatus.DONE).count();

    return (double) completedCount / tasks.size() * 100.0;
  }
}
