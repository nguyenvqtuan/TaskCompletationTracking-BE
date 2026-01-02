package com.example.tasktracker.infrastructure.persistence.mapper;

import com.example.tasktracker.domain.model.Task;
import com.example.tasktracker.infrastructure.persistence.entity.TaskJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskPersistenceMapper {

    public Task toDomain(TaskJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        return Task.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .priority(entity.getPriority())
                .dueDate(entity.getDueDate())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public TaskJpaEntity toEntity(Task task) {
        if (task == null) {
            return null;
        }
        return TaskJpaEntity.builder()
                .id(task.getId())
                .userId(task.getUserId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .dueDate(task.getDueDate())
                .createdAt(task.getCreatedAt())
                .build();
    }
}
