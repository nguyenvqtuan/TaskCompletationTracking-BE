package com.example.tasktracker.infrastructure.config;

import com.example.tasktracker.infrastructure.persistence.dao.SprintJpaDao;
import com.example.tasktracker.infrastructure.persistence.dao.TaskJpaDao;
import com.example.tasktracker.infrastructure.persistence.mapper.SprintPersistenceMapper;
import com.example.tasktracker.infrastructure.persistence.mapper.TaskPersistenceMapper;
import com.example.tasktracker.infrastructure.persistence.repository.SprintRepository;
import com.example.tasktracker.infrastructure.persistence.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConfig {

  @Bean
  public TaskRepository taskRepository(TaskJpaDao taskJpaDao, TaskPersistenceMapper mapper) {
    return new TaskRepository(taskJpaDao, mapper);
  }

  @Bean
  public SprintRepository sprintRepository(
      SprintJpaDao sprintJpaDao, SprintPersistenceMapper mapper) {
    return new SprintRepository(sprintJpaDao, mapper);
  }
}
