package com.example.tasktracker.application.services;

import com.example.tasktracker.application.dto.UpdateTaskRequest;
import com.example.tasktracker.application.exception.TaskNotFoundException;
import com.example.tasktracker.domain.model.Task;
import com.example.tasktracker.domain.model.TaskStatus;
import com.example.tasktracker.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateTaskService {

    private final TaskRepository taskRepository;

    public Task execute(UUID id, TaskStatus newStatus) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        
        task.changeStatus(newStatus);
        return taskRepository.save(task);
    }

    public Task execute(UUID id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        if (request.getTitle() != null) task.updateTitle(request.getTitle());
        if (request.getDescription() != null) task.updateDescription(request.getDescription());
        if (request.getStatus() != null) task.changeStatus(request.getStatus());
        if (request.getPriority() != null) task.changePriority(request.getPriority());
        if (request.getDueDate() != null) task.updateDueDate(request.getDueDate());

        return taskRepository.save(task);
    }
}
