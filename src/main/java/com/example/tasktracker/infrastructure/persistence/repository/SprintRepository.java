package com.example.tasktracker.infrastructure.persistence.repository;

import com.example.tasktracker.domain.model.Sprint;
import com.example.tasktracker.domain.model.SprintStatus;
import com.example.tasktracker.infrastructure.persistence.dao.SprintJpaDao;
import com.example.tasktracker.infrastructure.persistence.mapper.SprintPersistenceMapper;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SprintRepository
    implements com.example.tasktracker.domain.repository.SprintRepository {

  private final SprintJpaDao sprintJpaDao;
  private final SprintPersistenceMapper mapper;

  @Override
  public Sprint save(Sprint sprint) {
    var entity = mapper.toEntity(sprint);
    var savedEntity = sprintJpaDao.save(entity);
    return mapper.toDomain(savedEntity);
  }

  @Override
  public Optional<Sprint> findById(UUID id) {
    return sprintJpaDao.findById(id).map(mapper::toDomain);
  }

  @Override
  public List<Sprint> findAll() {
    return sprintJpaDao.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public List<Sprint> findByStatus(SprintStatus status) {
    return sprintJpaDao.findByStatus(status).stream()
        .map(mapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteById(UUID id) {
    sprintJpaDao.deleteById(id);
  }
}
