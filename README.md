# Task Completion Tracking - Backend

This is the backend service for the Task Completion Tracking application. It is built with Java 21 and Spring Boot 3.3.0.

## Prerequisites

*   **Java 21**: Ensure you have a JDK 21 installed.
*   **Docker**: Required for building the container image.
*   **Gradle**: The project uses the Gradle wrapper (`./gradlew`), so a local Gradle installation is not strictly necessary.

## Getting Started

### Run Locally

To run the application locally:

```bash
# Linux/macOS
./gradlew bootRun

# Windows
.\gradlew.bat bootRun
```

The application will start on port `8080`.

### Build with Docker

To build the Docker image:

```bash
docker build -t task-tracking-be .
```

To run the container:

```bash
docker run -p 8080:8080 task-tracking-be
```

## CI/CD Pipeline

The project includes a GitHub Actions workflow for Continuous Deployment.

*   **Workflow file**: `.github/workflows/cd.yml`
*   **Trigger**: Manual (`workflow_dispatch`)
*   **Action**: Builds the Docker image and pushes it to Amazon ECR.

### Configuration

The following variables must be set in the repository secrets/variables:

*   `AWS_ROLE_ARN`: The ARN of the IAM role to assume.
*   `AWS_REGION`: The AWS region (e.g., `us-east-1`).
*   `ECR_REPO`: The name of the ECR repository.
