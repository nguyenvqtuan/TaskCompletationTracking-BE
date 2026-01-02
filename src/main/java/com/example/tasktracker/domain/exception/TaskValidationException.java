package com.example.tasktracker.domain.exception;

public class TaskValidationException extends DomainException {
    public TaskValidationException(String message) {
        super(message);
    }
}
