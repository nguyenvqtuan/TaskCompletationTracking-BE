package com.example.tasktracker.domain.model;

// Reusing or create new
// exception
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Sprint {

  private final UUID id;
  private String name;
  private SprintStatus status;
  private Instant startDate;
  private Instant endDate;
  private final Instant createdAt;

  private Sprint(
      UUID id,
      String name,
      SprintStatus status,
      Instant startDate,
      Instant endDate,
      Instant createdAt) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.startDate = startDate;
    this.endDate = endDate;
    this.createdAt = createdAt;
    validate();
  }

  private void validate() {
    Objects.requireNonNull(name, "Name cannot be null");
    if (name.trim().isEmpty()) {
      throw new RuntimeException(
          "Name cannot be empty"); // Use standard exception for now or create custom
    }
    Objects.requireNonNull(status, "Status cannot be null");
    Objects.requireNonNull(createdAt, "CreatedAt cannot be null");
  }

  public void updateName(String name) {
    Objects.requireNonNull(name, "Name cannot be null");
    if (name.trim().isEmpty()) {
      throw new RuntimeException("Name cannot be empty");
    }
    this.name = name;
  }

  public void changeStatus(SprintStatus status) {
    Objects.requireNonNull(status, "Status cannot be null");
    this.status = status;
  }

  public void updateDates(Instant startDate, Instant endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public static class Builder {
    private UUID id;
    private String name;
    private SprintStatus status;
    private Instant startDate;
    private Instant endDate;
    private Instant createdAt;

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder status(SprintStatus status) {
      this.status = status;
      return this;
    }

    public Builder startDate(Instant startDate) {
      this.startDate = startDate;
      return this;
    }

    public Builder endDate(Instant endDate) {
      this.endDate = endDate;
      return this;
    }

    public Builder createdAt(Instant createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Sprint build() {
      if (this.status == null) this.status = SprintStatus.PLANNING;
      if (this.createdAt == null) this.createdAt = Instant.now();
      return new Sprint(id, name, status, startDate, endDate, createdAt);
    }
  }

  public static Builder builder() {
    return new Builder();
  }
}
