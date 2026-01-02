package com.example.tasktracker.infrastructure.persistence.dao;

import com.example.tasktracker.infrastructure.persistence.entity.UserJpaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaDao extends JpaRepository<UserJpaEntity, UUID> {}
