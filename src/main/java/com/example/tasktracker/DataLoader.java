package com.example.tasktracker;

import com.example.tasktracker.domain.model.Task;
import com.example.tasktracker.domain.model.TaskPriority;
import com.example.tasktracker.domain.model.TaskStatus;
import com.example.tasktracker.domain.repository.TaskRepository;
import com.example.tasktracker.infrastructure.persistence.dao.UserJpaDao;
import com.example.tasktracker.infrastructure.persistence.entity.UserJpaEntity;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final TaskRepository taskRepository;
  private final UserJpaDao userJpaDao;

  @Override
  public void run(String... args) throws Exception {
    if (userJpaDao.count() == 0) {
      UUID userId = UUID.randomUUID();
      UserJpaEntity user =
          UserJpaEntity.builder()
              .id(userId)
              .email("user@example.com")
              .passwordHash("password")
              .roles(Set.of("ROLE_USER"))
              .build();
      userJpaDao.save(user);

      Task task =
          Task.builder()
              .id(UUID.randomUUID())
              .userId(userId)
              .title("Example Task")
              .description("This is an example task created by DataLoader.")
              .status(TaskStatus.TODO)
              .priority(TaskPriority.MEDIUM)
              .createdAt(Instant.now())
              .dueDate(Instant.now().plus(1, ChronoUnit.DAYS))
              .build();

      taskRepository.save(task);

      System.out.println("Seed data initialized via Clean Architecture.");
    }
  }
}
