package com.example.tasktracker.presentation.rest;

import com.example.tasktracker.application.dto.CreateTaskCommand;
import com.example.tasktracker.application.services.*;
import com.example.tasktracker.domain.model.Task;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

  private final CreateTaskService createTaskService;
  private final GetTasksService getTasksService;
  private final UpdateTaskService updateTaskService;
  private final DeleteTaskService deleteTaskService;

  // CalculateProgressService can be exposed via a new endpoint if needed

  @GetMapping
  public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) UUID sprintId) {
    return ResponseEntity.ok(getTasksService.getAll(sprintId));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Task> getTaskById(@PathVariable UUID id) {
    return getTasksService
        .getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody @Valid CreateTaskCommand command) {
    Task createdTask = createTaskService.execute(command);
    return ResponseEntity.created(URI.create("/api/tasks/" + createdTask.getId()))
        .body(createdTask);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(
      @PathVariable UUID id,
      @RequestBody @Valid com.example.tasktracker.application.dto.UpdateTaskRequest request) {
    return ResponseEntity.ok(updateTaskService.execute(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
    deleteTaskService.execute(id);
    return ResponseEntity.noContent().build();
  }
}
