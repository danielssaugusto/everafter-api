# EverAfter API

RESTful API developed with **Java** and **Spring Boot** for managing wedding events. The project was created as a practical backend application to apply software engineering principles, layered architecture, data persistence, validation, exception handling, and automated testing.

## Overview

EverAfter API provides backend functionality for managing wedding events, guests, RSVP confirmations, and administrator access.

The project follows a layered architecture designed to keep responsibilities separated and make the application easier to maintain, test, and extend.

## Features

- Administrator management and authentication
- Guest management
- RSVP confirmation
- Wedding event management
- Request validation
- Centralized exception handling
- Data persistence with Spring Data JPA
- Unit testing with JUnit 5 and Mockito
- Support for H2 and MySQL databases, depending on the configuration

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Backend development |
| Spring Boot | Application framework |
| Spring Data JPA | Data persistence and ORM |
| Maven | Dependency and build management |
| H2 Database | Development and testing database |
| MySQL | Relational database |
| JUnit 5 | Unit testing |
| Mockito | Mocking and test isolation |
| Lombok | Boilerplate code reduction |

## Project Structure

    src
    ├── main
    │   ├── controller
    │   ├── service
    │   ├── repository
    │   ├── model
    │   ├── dto
    │   ├── exception
    │   └── config
    └── test
        └── service

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
- Git

You can verify the installed versions with:

    java -version
    mvn -version
    git --version

### Clone the Repository

    git clone https://github.com/danielssaugusto/everafter-api.git

Navigate to the project directory:

    cd everafter-api

### Running the Application

Using the Maven Wrapper:

    ./mvnw spring-boot:run

On Windows:

    mvnw.cmd spring-boot:run

Alternatively, if Maven is installed globally:

    mvn spring-boot:run

## Running Tests

To execute the automated tests:

    mvn test

The project uses **JUnit 5** and **Mockito** for unit testing.

## Database

The application can be configured to use either **H2** or **MySQL**, depending on the active Spring Boot configuration.

Database settings can be configured through the application's configuration files or environment variables.

Example:

    spring.datasource.url=jdbc:mysql://localhost:3306/everafter
    spring.datasource.username=root
    spring.datasource.password=your_password

For development and testing purposes, H2 can be used without requiring an external database server.

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
- Containerizing the application with Docker

## Roadmap

- [x] Administrator management
- [ ] Guest CRUD
- [ ] RSVP management
- [ ] Authentication with Spring Security and JWT
- [ ] Email notifications
- [ ] Wedding schedule management
- [ ] Docker support
- [ ] API documentation with Swagger/OpenAPI

Visit the official Git documentation:

https://git-scm.com/doc

The official documentation provides detailed information about Git commands, branching, merging, rebasing, configuration, and version control workflows.

## Author

**Daniel Augusto**

Backend developer focused on Java and Spring Boot development.

Feel free to open an issue, suggest improvements, or contribute to the project.