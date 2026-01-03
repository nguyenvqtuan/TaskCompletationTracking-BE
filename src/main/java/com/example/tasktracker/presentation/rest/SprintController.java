package com.example.tasktracker.presentation.rest;

import com.example.tasktracker.application.dto.CreateSprintCommand;
import com.example.tasktracker.application.dto.UpdateSprintCommand;
import com.example.tasktracker.application.services.*;
import com.example.tasktracker.domain.model.Sprint;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sprints")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class SprintController {

  private final CreateSprintService createSprintService;
  private final GetSprintsService getSprintsService;
  private final UpdateSprintService updateSprintService;
  private final DeleteSprintService deleteSprintService;

  @GetMapping
  public ResponseEntity<List<Sprint>> getAllSprints() {
    return ResponseEntity.ok(getSprintsService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Sprint> getSprintById(@PathVariable UUID id) {
    return getSprintsService
        .getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Sprint> createSprint(@RequestBody @Valid CreateSprintCommand command) {
    Sprint createdSprint = createSprintService.execute(command);
    return ResponseEntity.created(URI.create("/api/sprints/" + createdSprint.getId()))
        .body(createdSprint);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Sprint> updateSprint(
      @PathVariable UUID id, @RequestBody @Valid UpdateSprintCommand command) {
    return ResponseEntity.ok(updateSprintService.execute(id, command));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSprint(@PathVariable UUID id) {
    deleteSprintService.execute(id);
    return ResponseEntity.noContent().build();
  }
}
