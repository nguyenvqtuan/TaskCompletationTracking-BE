package com.example.tasktracker.infrastructure.config;

import com.example.tasktracker.application.mapper.SprintMapper;
import com.example.tasktracker.application.mapper.TaskMapper;
import com.example.tasktracker.application.services.*;
import com.example.tasktracker.domain.repository.SprintRepository;
import com.example.tasktracker.domain.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public CreateTaskService createTaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
    return new CreateTaskService(taskRepository, taskMapper);
  }

  @Bean
  public UpdateTaskService updateTaskService(TaskRepository taskRepository) {
    return new UpdateTaskService(taskRepository);
  }

  @Bean
  public DeleteTaskService deleteTaskService(TaskRepository taskRepository) {
    return new DeleteTaskService(taskRepository);
  }

  @Bean
  public GetTasksService getTasksService(TaskRepository taskRepository) {
    return new GetTasksService(taskRepository);
  }

  @Bean
  public CalculateProgressService calculateProgressService(TaskRepository taskRepository) {
    return new CalculateProgressService(taskRepository);
  }

  @Bean
  public CreateSprintService createSprintService(
      SprintRepository sprintRepository, SprintMapper sprintMapper) {
    return new CreateSprintService(sprintRepository, sprintMapper);
  }

  @Bean
  public GetSprintsService getSprintsService(SprintRepository sprintRepository) {
    return new GetSprintsService(sprintRepository);
  }

  @Bean
  public UpdateSprintService updateSprintService(SprintRepository sprintRepository) {
    return new UpdateSprintService(sprintRepository);
  }

  @Bean
  public DeleteSprintService deleteSprintService(SprintRepository sprintRepository) {
    return new DeleteSprintService(sprintRepository);
  }
}
