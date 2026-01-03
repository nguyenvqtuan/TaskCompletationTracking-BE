package com.example.tasktracker.application.services;

import com.example.tasktracker.application.dto.UpdateSprintCommand;
import com.example.tasktracker.domain.model.Sprint;
import com.example.tasktracker.domain.repository.SprintRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateSprintService {

  private final SprintRepository sprintRepository;

  public Sprint execute(UUID id, UpdateSprintCommand command) {
    Sprint sprint =
        sprintRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Sprint not found with id: " + id));

    sprint.updateName(command.getName());
    if (command.getStatus() != null) {
      sprint.changeStatus(command.getStatus());
    }
    sprint.updateDates(command.getStartDate(), command.getEndDate());

    return sprintRepository.save(sprint);
  }
}
