# Student Management API

A RESTful CRUD API built with Spring Boot for managing student records, backed by Oracle Database.

## Overview

This project demonstrates a standard layered architecture (Controller → Service → Repository) using Spring Boot and Spring Data JPA. It supports full Create, Read, Update, and Delete operations on student records, with sequence-based primary key generation and persistent storage in Oracle DB.

## Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 4.1.0 (Spring Web, Spring Data JPA)
- **Database:** Oracle Database
- **Build Tool:** Maven
- **Testing:** Postman

## Architecture

```
Client (Postman/Browser)
   ↓
Controller  → handles HTTP requests and responses
   ↓
Service     → business logic
   ↓
Repository  → database operations (Spring Data JPA)
   ↓
Oracle Database
```

## API Endpoints

| Method | Endpoint          | Description                  |
|--------|-------------------|-------------------------------|
| POST   | `/students`       | Create a new student          |
| GET    | `/students`       | Get all students               |
| GET    | `/students/{id}`  | Get a student by ID            |
| PUT    | `/students/{id}`  | Update a student's details     |
| DELETE | `/students/{id}`  | Delete a student by ID         |

### Example Request (POST /students)

```json
{
    "name": "Dharani S",
    "email": "dharani@example.com"
}
```

### Example Response

```json
{
    "id": 1,
    "name": "Dharani S",
    "email": "dharani@example.com"
}
```

## Getting Started

### Prerequisites
- Java 17+
- Maven
- Oracle Database instance running locally

### Configuration
Update `src/main/resources/application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.hibernate.ddl-auto=update
```

### Run the application

```bash
mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

## Future Improvements
- Input validation (e.g. required fields, email format)
- Proper error handling with meaningful HTTP status codes (e.g. 404 for not found)
- Connect a frontend (HTML/JS) for a complete full-stack demo
