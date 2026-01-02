package com.example.tasktracker.application.services;

import com.example.tasktracker.application.dto.CreateTaskCommand;
import com.example.tasktracker.application.mapper.TaskMapper;
import com.example.tasktracker.domain.model.Task;
import com.example.tasktracker.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

// No Spring @Service annotation - Pure Java
@RequiredArgsConstructor
public class CreateTaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public Task execute(CreateTaskCommand command) {
        Task task = taskMapper.toDomain(command);
        // Validation could go here if not in Entity
        return taskRepository.save(task);
    }
}
