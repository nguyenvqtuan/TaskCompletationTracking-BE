package com.example.tasktracker.application.dto;

import com.example.tasktracker.domain.model.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

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
