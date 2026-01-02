package com.example.tasktracker.application.dto;

import com.example.tasktracker.domain.model.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskCommand {

  @NotBlank(message = "Title is required")
  private String title;

  private String description;

  private TaskPriority priority;

  private Instant dueDate;
}
