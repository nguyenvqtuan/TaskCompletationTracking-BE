package com.example.tasktracker.application.services;

import com.example.tasktracker.domain.repository.SprintRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteSprintService {

  private final SprintRepository sprintRepository;

  public void execute(UUID id) {
    sprintRepository.deleteById(id);
  }
}
