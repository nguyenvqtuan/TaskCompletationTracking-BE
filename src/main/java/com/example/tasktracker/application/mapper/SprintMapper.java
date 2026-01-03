package com.example.tasktracker.application.mapper;

import com.example.tasktracker.application.dto.CreateSprintCommand;
import com.example.tasktracker.domain.model.Sprint;
import org.springframework.stereotype.Component;

@Component
public class SprintMapper {

  public Sprint toDomain(CreateSprintCommand command) {
    if (command == null) {
      return null;
    }
    return Sprint.builder()
        .name(command.getName())
        .status(command.getStatus())
        .startDate(command.getStartDate())
        .endDate(command.getEndDate())
        .build();
  }
}
