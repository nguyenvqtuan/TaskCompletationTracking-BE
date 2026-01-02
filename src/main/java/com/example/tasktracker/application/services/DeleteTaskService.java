package com.example.tasktracker.application.services;

import com.example.tasktracker.application.exception.TaskNotFoundException;
import com.example.tasktracker.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteTaskService {

    private final TaskRepository taskRepository;

    public void execute(UUID id) {
        if (!taskRepository.findById(id).isPresent()) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
