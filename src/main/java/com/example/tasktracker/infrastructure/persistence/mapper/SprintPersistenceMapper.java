package com.example.tasktracker.infrastructure.persistence.mapper;

import com.example.tasktracker.domain.model.Sprint;
import com.example.tasktracker.infrastructure.persistence.entity.SprintJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class SprintPersistenceMapper {

  public SprintJpaEntity toEntity(Sprint sprint) {
    if (sprint == null) return null;
    return SprintJpaEntity.builder()
        .id(sprint.getId())
        .name(sprint.getName())
        .status(sprint.getStatus())
        .startDate(sprint.getStartDate())
        .endDate(sprint.getEndDate())
        .createdAt(sprint.getCreatedAt())
        .build();
  }

  public Sprint toDomain(SprintJpaEntity entity) {
    if (entity == null) return null;
    return Sprint.builder()
        .id(entity.getId())
        .name(entity.getName())
        .status(entity.getStatus())
        .startDate(entity.getStartDate())
        .endDate(entity.getEndDate())
        .createdAt(entity.getCreatedAt())
        .build();
  }
}
