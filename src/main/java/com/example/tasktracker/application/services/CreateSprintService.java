package com.example.tasktracker.application.services;

import com.example.tasktracker.application.dto.CreateSprintCommand;
import com.example.tasktracker.application.mapper.SprintMapper;
import com.example.tasktracker.domain.model.Sprint;
import com.example.tasktracker.domain.repository.SprintRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateSprintService {

  private final SprintRepository sprintRepository;
  private final SprintMapper sprintMapper;

  public Sprint execute(CreateSprintCommand command) {
    Sprint sprint = sprintMapper.toDomain(command);
    return sprintRepository.save(sprint);
  }
}
