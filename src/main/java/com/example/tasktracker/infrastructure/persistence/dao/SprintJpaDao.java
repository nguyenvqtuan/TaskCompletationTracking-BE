package com.example.tasktracker.infrastructure.persistence.dao;

import com.example.tasktracker.domain.model.SprintStatus;
import com.example.tasktracker.infrastructure.persistence.entity.SprintJpaEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintJpaDao extends JpaRepository<SprintJpaEntity, UUID> {
  List<SprintJpaEntity> findByStatus(SprintStatus status);
}
