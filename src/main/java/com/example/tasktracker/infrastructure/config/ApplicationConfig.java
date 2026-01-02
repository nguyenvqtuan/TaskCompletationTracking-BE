package com.example.tasktracker.infrastructure.config;

import com.example.tasktracker.application.mapper.TaskMapper;
import com.example.tasktracker.application.services.*;
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
}
