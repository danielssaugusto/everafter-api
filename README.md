# EverAfter API

RESTful API developed with **Java** and **Spring Boot** for managing wedding events. The project was created as a practical backend application to apply software engineering principles, layered architecture, data persistence, validation, exception handling, and automated testing.

## Overview

EverAfter API provides backend functionality for managing wedding events, guests, RSVP confirmations, and administrator access.

The project follows a layered architecture designed to keep responsibilities separated and make the application easier to maintain, test, and extend.

The application uses **Docker Compose to run PostgreSQL**, while the **Spring Boot application runs directly on the host machine**.

## Features

- Administrator management and authentication
- Guest management
- RSVP confirmation
- Wedding event management
- Request validation
- Centralized exception handling
- Data persistence with Spring Data JPA
- Unit testing with JUnit 5 and Mockito
- PostgreSQL database running with Docker Compose

## Technology Stack

| Technology      | Purpose                         |
| --------------- | ------------------------------- |
| Java            | Backend development             |
| Spring Boot     | Application framework           |
| Spring Data JPA | Data persistence and ORM        |
| Maven           | Dependency and build management |
| PostgreSQL      | Relational database             |
| Docker          | Containerization                |
| Docker Compose  | Local database infrastructure   |
| JUnit 5         | Unit testing                    |
| Mockito         | Mocking and test isolation      |
| Lombok          | Boilerplate code reduction      |

## Project Structure

    everafter-api/
    ├── .mvn/
    │   └── wrapper/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   └── resources/
    │   └── test/
    │       └── java/
    ├── .env.example
    ├── .gitignore
    ├── compose.yml
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    └── README.md

## Architecture

The application is organized into layers with specific responsibilities:

- **Controller** — Handles HTTP requests and responses.
- **Service** — Contains business logic and application rules.
- **Repository** — Responsible for database access through Spring Data JPA.
- **Model** — Represents the application's domain entities.
- **DTO** — Defines the data structures exchanged through the API.
- **Exception** — Contains custom exceptions and exception handling.
- **Config** — Contains application and framework configurations.

This structure helps maintain separation of concerns and facilitates testing and future development.

## Getting Started

### Prerequisites

Before running the project, make sure you have installed:

- Java JDK
- Maven
- Docker
- Docker Compose
- Git

You can verify the installations with:

    java -version
    mvn -version
    docker --version
    docker compose version
    git --version

### Clone the Repository

    git clone https://github.com/danielssaugusto/everafter-api.git

Navigate to the project directory:

    cd everafter-api

## Database

The application uses **PostgreSQL** as its relational database.

PostgreSQL runs inside a Docker container, while the Spring Boot application runs directly on the host machine.

### Start the Database

Start the PostgreSQL container using Docker Compose:

    docker compose up -d

Check whether the container is running:

    docker compose ps

To view the PostgreSQL logs:

    docker compose logs -f postgres

### Stop the Database

To stop the PostgreSQL container:

    docker compose down

To stop the container and remove its volumes:

    docker compose down -v

> **Warning:** `docker compose down -v` removes the PostgreSQL volume and will delete the database data stored in it.

## Environment Variables

Database configuration is managed through environment variables.

Create a `.env` file based on the provided `.env.example`:

    cp .env.example .env

Example `.env` configuration:

    POSTGRES_DB=everafter
    POSTGRES_USER=postgres
    POSTGRES_PASSWORD=your_password
    POSTGRES_PORT=5432

The `.env` file should not be committed to the repository.

Only `.env.example` should be versioned.

## Running the Application

The Spring Boot application runs directly on the host machine.

First, make sure the PostgreSQL container is running:

    docker compose up -d

Then start the Spring Boot application.

Using the Maven Wrapper:

    ./mvnw spring-boot:run

On Windows:

    mvnw.cmd spring-boot:run

Alternatively, if Maven is installed globally:

    mvn spring-boot:run

Once the application starts, the API will be available at:

    http://localhost:8080

## Database Configuration

The Spring Boot application connects to the PostgreSQL container through the host machine.

Example configuration:

    spring.datasource.url=jdbc:postgresql://localhost:5432/everafter
    spring.datasource.username=postgres
    spring.datasource.password=your_password

The database connection settings must match the values configured in the `.env` file.

Because PostgreSQL is exposed from the Docker container to the host machine, the Spring Boot application connects to it through:

    localhost:5432

## Running Tests

To execute the automated tests:

    mvn test

The project uses **JUnit 5** and **Mockito** for unit testing.

## API

The application exposes RESTful endpoints for managing the application's resources.

The API is being developed incrementally, with authentication, guest management, RSVP management, and event management planned as part of the project's roadmap.

API documentation using **Swagger/OpenAPI** is planned for a future version.

## Project Goals

This project was created as a practical environment for improving backend development skills while applying software engineering practices commonly used in production applications.

The main goals include:

- Designing RESTful APIs
- Applying layered architecture
- Practicing Clean Code principles
- Applying SOLID principles
- Implementing data persistence with JPA
- Writing unit tests
- Implementing validation and exception handling
- Working with relational databases
- Improving Git and GitHub workflows
- Exploring authentication and authorization
- Using Docker for local infrastructure

## Roadmap

- [x] Administrator management
- [ ] Guest CRUD
- [ ] RSVP management
- [ ] Authentication with Spring Security and JWT
- [ ] Email notifications
- [ ] Wedding schedule management
- [ ] Docker support
- [ ] API documentation with Swagger/OpenAPI

## Git Basics

Git is the version control system used to manage the project's source code and track changes throughout development.

### Clone a Repository

    git clone <repository-url>

### Check the Current Status

    git status

### Create a New Branch

    git switch -c feature/my-feature

### Stage Changes

Stage a specific file:

    git add filename

Stage all modified files:

    git add .

### Create a Commit

    git commit -m "Add guest management"

### Push Changes

    git push origin feature/my-feature

### Update the Local Repository

    git pull

### View Commit History

    git log

### View Branches

    git branch

### Switch Branches

    git switch main

For complete documentation, visit the official Git documentation:

https://git-scm.com/doc

The official documentation provides detailed information about Git commands, branching, merging, rebasing, configuration, and version control workflows.

## Author

**Daniel Augusto**

Backend developer focused on Java and Spring Boot development.

Feel free to open an issue, suggest improvements, or contribute to the project.