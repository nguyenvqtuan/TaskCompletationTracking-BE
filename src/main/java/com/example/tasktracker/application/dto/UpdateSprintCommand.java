package com.example.tasktracker.application.dto;

import com.example.tasktracker.domain.model.SprintStatus;
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
public class UpdateSprintCommand {

  @NotBlank(message = "Name is required")
  private String name;

  private SprintStatus status;
  private Instant startDate;
  private Instant endDate;
}
