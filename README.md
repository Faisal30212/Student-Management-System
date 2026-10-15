# Student Management System

A Java-based backend application built using Spring Boot to manage student records through REST APIs.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JUnit and Mockito (if configured in the project)

## Features

- Add student records
- Retrieve all students
- Retrieve a student by ID
- Delete a student by ID
- Validate student data
- Persist student information in a database

## Project Structure

- `controller/` — REST API endpoints
- `dto/` — Data Transfer Objects
- `entity/` — Student entity
- `repository/` — Database access
- `service/` — Business logic
- `src/test/` — Test classes

## Getting Started

### Prerequisites

- Java and Maven
- MySQL Server

### Run the Application

Configure your database connection in `application.properties`, then run:

```bash
mvn spring-boot:run
```

The application runs on port `8080` by default.

## Purpose

This project demonstrates Spring Boot REST API development, layered architecture, database integration, and student record management.
