package com.example.tasktracker.domain.model;

import com.example.tasktracker.domain.exception.TaskValidationException;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Task {

  private final UUID id;
  private UUID userId; // Ownership
  private String title;
  private String description;
  private TaskStatus status;
  private TaskPriority priority;
  private Instant dueDate;
  private final Instant createdAt;

  // Private constructor to enforce validation via Builder/Factory
  private Task(
      UUID id,
      UUID userId,
      String title,
      String description,
      TaskStatus status,
      TaskPriority priority,
      Instant dueDate,
      Instant createdAt) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.description = description;
    this.status = status;
    this.priority = priority;
    this.dueDate = dueDate;
    this.createdAt = createdAt;
    validate();
  }

  private void validate() {
    Objects.requireNonNull(title, "Title cannot be null");
    if (title.trim().isEmpty()) {
      throw new TaskValidationException("Title cannot be empty");
    }
    Objects.requireNonNull(status, "Status cannot be null");
    Objects.requireNonNull(priority, "Priority cannot be null");
    Objects.requireNonNull(createdAt, "CreatedAt cannot be null");
  }

  // Business Methods to mutate state
  public void updateTitle(String title) {
    Objects.requireNonNull(title, "Title cannot be null");
    if (title.trim().isEmpty()) {
      throw new TaskValidationException("Title cannot be empty");
    }
    this.title = title;
  }

  public void updateDescription(String description) {
    this.description = description;
  }

  public void changeStatus(TaskStatus status) {
    Objects.requireNonNull(status, "Status cannot be null");
    this.status = status;
  }

  public void changePriority(TaskPriority priority) {
    Objects.requireNonNull(priority, "Priority cannot be null");
    this.priority = priority;
  }

  public void updateDueDate(Instant dueDate) {
    this.dueDate = dueDate;
  }

  // Custom Builder to handle defaults and final fields
  public static class Builder {
    private UUID id;
    private UUID userId;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private Instant dueDate;
    private Instant createdAt;

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Builder userId(UUID userId) {
      this.userId = userId;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder status(TaskStatus status) {
      this.status = status;
      return this;
    }

    public Builder priority(TaskPriority priority) {
      this.priority = priority;
      return this;
    }

    public Builder dueDate(Instant dueDate) {
      this.dueDate = dueDate;
      return this;
    }

    public Builder createdAt(Instant createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Task build() {
      // Set defaults
      if (this.status == null) this.status = TaskStatus.TODO;
      if (this.priority == null) this.priority = TaskPriority.MEDIUM;
      if (this.createdAt == null) this.createdAt = Instant.now();

      return new Task(id, userId, title, description, status, priority, dueDate, createdAt);
    }
  }

  public static Builder builder() {
    return new Builder();
  }
}
