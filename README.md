# 💍 EverAfter API

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![JUnit 5](https://img.shields.io/badge/JUnit-5-success)
![Mockito](https://img.shields.io/badge/Mockito-Testing-blue)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A RESTful API built with **Java** and **Spring Boot** for managing wedding events. The project provides features for administrator authentication, guest management, RSVP confirmation, and event organization through a clean and scalable backend architecture.

## ✨ Features

- 🔐 Administrator authentication
- 👥 Guest management
- 📩 RSVP confirmation
- 📅 Wedding event management
- ✅ Input validation
- ⚠️ Exception handling
- 🧪 Unit testing with JUnit 5 and Mockito
- 🗄️ Spring Data JPA integration

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Maven
- H2 Database / MySQL *(depending on configuration)*
- JUnit 5
- Mockito
- Lombok

## 📂 Project Structure

```
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
```

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/danielssaugusto/everafter-api.git
```

### Navigate to the project

```bash
cd everafter-api
```

### Run the application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

## 🧪 Running Tests

```bash
mvn test
```

## 📌 Project Goals

This project was created to improve my backend development skills while applying software engineering best practices, including:

- RESTful API design
- Layered architecture
- Clean Code
- SOLID principles
- Unit testing
- Validation and exception handling
- Git & GitHub workflow

## 📈 Roadmap

- [x] Administrator management
- [ ] Guest CRUD
- [ ] RSVP management
- [ ] Authentication with Spring Security & JWT
- [ ] Email notifications
- [ ] Wedding schedule management
- [ ] Docker support
- [ ] API documentation with Swagger/OpenAPI

## 👨‍💻 Author

Developed by **Daniel Augusto**

Feel free to open issues, submit suggestions, or contribute to the project.
