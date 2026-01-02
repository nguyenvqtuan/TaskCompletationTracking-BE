package com.example.tasktracker.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserJpaEntity {

  @Id private UUID id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String passwordHash;

  @ElementCollection(fetch = FetchType.EAGER)
  private Set<String> roles;
}
