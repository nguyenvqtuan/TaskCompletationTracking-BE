package com.example.tasktracker.infrastructure.persistence.dao;

import com.example.tasktracker.domain.model.TaskStatus;
import com.example.tasktracker.infrastructure.persistence.entity.TaskJpaEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJpaDao extends JpaRepository<TaskJpaEntity, UUID> {
  List<TaskJpaEntity> findByStatus(TaskStatus status);
}
