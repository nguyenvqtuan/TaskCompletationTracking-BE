package com.example.tasktracker.infrastructure.persistence.repository;

import com.example.tasktracker.domain.model.Task;
import com.example.tasktracker.domain.model.TaskStatus;
import com.example.tasktracker.infrastructure.persistence.dao.TaskJpaDao;
import com.example.tasktracker.infrastructure.persistence.mapper.TaskPersistenceMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TaskRepository implements com.example.tasktracker.domain.repository.TaskRepository {

    private final TaskJpaDao taskJpaDao;
    private final TaskPersistenceMapper mapper;

    @Override
    public Task save(Task task) {
        var entity = mapper.toEntity(task);
        var savedEntity = taskJpaDao.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return taskJpaDao.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return taskJpaDao.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> findByStatus(TaskStatus status) {
        return taskJpaDao.findByStatus(status).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        taskJpaDao.deleteById(id);
    }
}
