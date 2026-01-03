package com.example.tasktracker.infrastructure.persistence.entity;

import com.example.tasktracker.domain.model.SprintStatus;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "sprints")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SprintJpaEntity {

  @Id @UuidGenerator private UUID id;

  @Column(nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SprintStatus status;

  private Instant startDate;
  private Instant endDate;

  @Column(nullable = false)
  private Instant createdAt;
}
