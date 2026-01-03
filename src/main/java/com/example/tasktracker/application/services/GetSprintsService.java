package com.example.tasktracker.application.services;

import com.example.tasktracker.domain.model.Sprint;
import com.example.tasktracker.domain.repository.SprintRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetSprintsService {

  private final SprintRepository sprintRepository;

  public List<Sprint> getAll() {
    return sprintRepository.findAll();
  }

  public Optional<Sprint> getById(UUID id) {
    return sprintRepository.findById(id);
  }
}
