package com.example.tasktracker.domain.repository;

import com.example.tasktracker.domain.model.Sprint;
import com.example.tasktracker.domain.model.SprintStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SprintRepository {
  Sprint save(Sprint sprint);

  Optional<Sprint> findById(UUID id);

  List<Sprint> findAll();

  List<Sprint> findByStatus(SprintStatus status);

  void deleteById(UUID id);
}
