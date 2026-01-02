package com.example.tasktracker.application.dto;

import com.example.tasktracker.domain.model.TaskPriority;
import com.example.tasktracker.domain.model.TaskStatus;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskRequest {
    
    @Size(min = 1, message = "Title cannot be empty")
    private String title;
    
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private Instant dueDate;
}
