package com.example.tasktracker.domain.model;

import com.example.tasktracker.domain.exception.TaskValidationException;
import lombok.Getter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
public class User {
    
    private final UUID id;
    private String email;
    private String passwordHash;
    private final Set<String> roles; // Simple string roles for now (USER, ADMIN)

    public User(UUID id, String email, String passwordHash, Set<String> roles) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = roles != null ? roles : new HashSet<>();
        validate();
    }

    private void validate() {
        Objects.requireNonNull(id, "User ID cannot be null");
        Objects.requireNonNull(email, "Email cannot be null");
        Objects.requireNonNull(passwordHash, "Password Hash cannot be null");
    }
}
