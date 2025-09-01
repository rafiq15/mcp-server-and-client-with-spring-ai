# Spring AI MCP Server and Client

This repository contains two Spring Boot applications:
- **spring-ai-mcp-server**: A backend RESTful API server for managing medical reports and patient data.
- **spring-ai-mcp-client**: A client application that interacts with the server, providing a user interface and consuming the server's APIs.

Both modules are built with Java, Spring Boot, and Gradle.

---

## Table of Contents
- [Architecture Overview](#architecture-overview)
- [Server Module](#server-module)
  - [Features](#features)
  - [Project Structure](#project-structure)
  - [Key Classes](#key-classes)
  - [Configuration](#configuration)
- [Client Module](#client-module)
  - [Features](#client-features)
  - [Project Structure](#client-project-structure)
  - [Key Classes](#client-key-classes)
  - [Configuration](#client-configuration)
- [Build & Run](#build--run)
- [API Endpoints](#api-endpoints)
- [License](#license)

---

## Architecture Overview

The system is split into two independent Spring Boot applications:
- **Server** exposes REST APIs for CRUD operations on medical reports and patients, using a layered architecture (Controller, Service, Repository, Entity, DTO).
- **Client** acts as a consumer of the server's APIs, providing a UI or further API endpoints for end-users or other systems.

---

## Server Module

### Features
- RESTful API for managing medical reports and patients
- Layered architecture: Controller, Service, Repository, Entity, DTO
- Data persistence (typically with JPA/Hibernate)
- Exception handling
- Configurable via `application.yaml`

### Project Structure
```
src/main/java/com/spring/ai/mcp/server/
  ├── SpringAiMcpServerApplication.java
  ├── controller/           # (if present) REST controllers
  ├── dto/                  # Data Transfer Objects
  ├── entity/               # JPA Entities
  ├── repository/           # Spring Data JPA Repositories
  └── service/              # Business logic
src/main/resources/
  └── application.yaml      # Configuration
```

### Key Classes
- **SpringAiMcpServerApplication.java**: Main entry point for the server application.
- **entity/**: Contains JPA entities like `Patient` and `MedicalReport`.
- **dto/**: Contains DTOs for API requests/responses, e.g., `PatientDTO`, `MedicalReportDTO`.
- **repository/**: Spring Data interfaces for database access.
- **service/MedicalService.java**: Business logic for managing patients and reports.

### Configuration
- `src/main/resources/application.yaml`: Contains server configuration (port, DB, etc).

---

## Client Module

### Features
- Consumes the server's REST APIs
- May provide a web UI or further REST endpoints
- Configurable via `application.yaml`

### Project Structure
```
src/main/java/com/spring/ai/mcp/client/
  ├── SpringAiMcpClientApplication.java
  └── controller/           # Controllers for client endpoints/UI
src/main/resources/
  └── application.yaml      # Configuration
```

### Key Classes
- **SpringAiMcpClientApplication.java**: Main entry point for the client application.
- **controller/MedicalController.java**: Handles client-side endpoints or UI logic.

### Configuration
- `src/main/resources/application.yaml`: Contains client configuration (server URL, etc).

---

## Build & Run

### Prerequisites
- Java 17+
- Gradle 7+

### Build
From each module directory (`spring-ai-mcp-server` and `spring-ai-mcp-client`):

```powershell
./gradlew build
```

### Run
From each module directory:

```powershell
./gradlew bootRun
```

---

## API Endpoints

### Server Endpoints (examples)
- `GET /api/patients` - List all patients
- `POST /api/patients` - Create a new patient
- `GET /api/reports` - List all medical reports
- `POST /api/reports` - Create a new medical report

(See controller classes for full details.)

---

## License

This project is licensed under the MIT License.
