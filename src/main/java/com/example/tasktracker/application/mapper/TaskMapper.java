package com.example.tasktracker.application.mapper;

import com.example.tasktracker.application.dto.CreateTaskCommand;
import com.example.tasktracker.domain.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

  public Task toDomain(CreateTaskCommand command) {
    if (command == null) {
      return null;
    }
    return Task.builder()
        .title(command.getTitle())
        .description(command.getDescription())
        .priority(command.getPriority())
        .dueDate(command.getDueDate())
        .build();
  }
}
