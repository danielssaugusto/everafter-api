# EverAfter API

RESTful API developed with **Java** and **Spring Boot** for managing wedding events, guests, RSVP confirmations, and administrator access.

The project was created as a practical backend application to develop and apply software engineering practices such as layered architecture, data persistence, validation, exception handling, automated testing, and Git-based development workflows.

## About the Project

EverAfter API is a backend application designed to manage the main resources involved in a wedding event.

The application provides the foundation for:

- Administrator management
- Wedding event management
- Guest management
- RSVP confirmations
- Request validation
- Exception handling
- Persistent data storage
- Automated testing

The project is being developed incrementally, with additional features planned for future versions.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Backend development |
| Spring Boot | Application framework |
| Spring Data JPA | Data persistence |
| Gradle | Build and dependency management |
| PostgreSQL | Relational database |
| Docker | Containerization |
| Docker Compose | Local database infrastructure |
| JUnit 5 | Automated testing |
| Mockito | Unit test mocking |
| Lombok | Boilerplate code reduction |

## Project Structure

The application follows a layered architecture to separate responsibilities and keep the codebase maintainable.

The main layers are:

- **Controller** — Handles HTTP requests and responses.
- **Service** — Contains application and business logic.
- **Repository** — Handles database access through Spring Data JPA.
- **Entity/Model** — Represents persistent domain data.
- **DTO** — Defines the data exchanged through the API.
- **Exception** — Contains application-specific exceptions and centralized exception handling.

## Prerequisites

Before running the application, make sure the following tools are installed:

- Java JDK 21 or newer
- Docker
- Docker Compose
- Git

The project uses the **Gradle Wrapper**, so installing Gradle globally is not required.

Verify your Java installation:

```bash
java -version
````

Verify Docker:

```bash
docker --version
```

Verify Docker Compose:

```bash
docker compose version
```

## Running the Application

Follow these steps to run the project locally.

### 1. Clone the Repository

```bash
git clone https://github.com/danielssaugusto/everafter-api.git
```

Navigate to the project directory:

```bash
cd everafter-api
```

### 2. Configure Environment Variables

Create the environment file from the provided example:

```bash
cp .env.example .env
```

Open the `.env` file and configure the database credentials:

```env
POSTGRES_DB=everafter
POSTGRES_USER=postgres
POSTGRES_PASSWORD=your_password
POSTGRES_PORT=5432
```

Do not commit the `.env` file to the repository.

Only `.env.example` should be versioned.

### 3. Start PostgreSQL

The PostgreSQL database runs through Docker Compose.

Start the database:

```bash
docker compose up -d
```

Check whether the container is running:

```bash
docker compose ps
```

You can also check the database logs:

```bash
docker compose logs -f postgres
```

The database is exposed to the host machine through port `5432`.

### 4. Run the Application

Make sure PostgreSQL is running before starting Spring Boot.

On Linux or macOS:

```bash
./gradlew bootRun
```

On Windows:

```cmd
gradlew.bat bootRun
```

The application will start on:

```text
http://localhost:8080
```

### 5. Verify the Application

Once Spring Boot has started successfully, access the API through:

```text
http://localhost:8080
```

If the application exposes a health endpoint, it can be used to verify that the API is running correctly.

## Running Tests

Run the complete test suite with the Gradle Wrapper.

On Linux or macOS:

```bash
./gradlew test
```

On Windows:

```cmd
gradlew.bat test
```

The project uses:

* **JUnit 5** for testing
* **Mockito** for mocking dependencies and isolating unit tests

## Stopping the Application

Stop the Spring Boot application with:

```text
Ctrl + C
```

To stop the PostgreSQL container:

```bash
docker compose down
```

To stop the container and remove its associated volumes:

```bash
docker compose down -v
```

> **Warning:** `docker compose down -v` removes the PostgreSQL volume and permanently deletes the database data stored in that volume.

## Development Workflow

A typical development workflow is:

```text
Clone repository
      ↓
Configure environment
      ↓
Start PostgreSQL
      ↓
Create a feature branch
      ↓
Implement changes
      ↓
Run tests
      ↓
Commit changes
      ↓
Push branch
      ↓
Open Pull Request
```

Create a feature branch:

```bash
git switch -c feature/my-feature
```

Check the current changes:

```bash
git status
```

Stage changes:

```bash
git add .
```

Create a commit:

```bash
git commit -m "Add guest management"
```

Push the branch:

```bash
git push origin feature/my-feature
```

Update the local repository:

```bash
git pull
```

Switch back to the main branch:

```bash
git switch main
```

## Git Commit Convention

The project follows the **Conventional Commits** approach.

Examples:

```text
feat: add guest management
fix: handle invalid RSVP requests
refactor: migrate from Maven to Gradle
test: add guest service tests
docs: update setup instructions
chore: update project dependencies
```

## API

The API follows REST principles and exposes endpoints for the application's main resources.

Current and planned resources include:

* Administrators
* Wedding events
* Guests
* RSVP confirmations

API documentation using **Swagger/OpenAPI** is planned for a future version.

## Roadmap

* [x] Administrator management
* [ ] Guest CRUD
* [ ] RSVP management
* [ ] Authentication with Spring Security and JWT
* [ ] Email notifications
* [ ] Wedding schedule management
* [ ] Docker support
* [ ] API documentation with Swagger/OpenAPI

## Project Goals

The main goal of EverAfter API is to provide a practical environment for developing backend engineering skills while following practices commonly used in professional software projects.

The project focuses on:

* Designing RESTful APIs
* Applying layered architecture
* Practicing Clean Code
* Applying SOLID principles
* Working with Spring Boot
* Implementing data persistence with JPA
* Writing automated tests
* Implementing validation and exception handling
* Working with relational databases
* Managing dependencies with Gradle
* Using Docker for local infrastructure
* Practicing Git and GitHub workflows
* Exploring authentication and authorization

## Author

**Daniel Augusto**

Backend developer focused on Java and Spring Boot development.

For questions, suggestions, or improvements, feel free to open an issue or contribute to the project.

```
```
