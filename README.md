
# Spring AI MCP (Model Context Protocol) Server and Client


This repository demonstrates the use of the **Model Context Protocol (MCP)** with Spring AI. MCP is a protocol for structuring, exchanging, and managing context between clients, servers, and AI models, enabling advanced AI-powered applications.

It contains two Spring Boot applications:
- **spring-ai-mcp-server**: A backend RESTful API server implementing MCP for managing medical reports and patient data, and orchestrating communication with AI models.
- **spring-ai-mcp-client**: A client application that interacts with the server using MCP, providing a user interface and consuming the server's AI-powered APIs.

Both modules are built with Java, Spring Boot, and Gradle, and leverage Spring AI's MCP integration for seamless context management and AI model interaction.

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

This system is designed around the **Model Context Protocol (MCP)**, which standardizes how context is exchanged between the client, server, and AI model. MCP enables:
- Consistent context passing for AI inference
- Enhanced traceability and explainability
- Modular integration of different AI models (e.g., Llama via Ollama)

**Server**: Implements MCP endpoints, manages business logic, and communicates with the AI model using Spring AI's MCP support.

**Client**: Consumes MCP endpoints, structures requests using the protocol, and presents results to users or other systems.

---

## Server Module


### Features
- Implements Model Context Protocol (MCP) for context-rich AI interactions
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
- **MCP Integration**: Uses Spring AI's MCP modules to structure and manage context for AI model calls.

### Configuration
- `src/main/resources/application.yaml`: Contains server configuration (port, DB, etc).

---

## Client Module


### Features
- Consumes MCP-enabled REST APIs from the server
- Structures requests and responses using Model Context Protocol
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
- **MCP Integration**: Uses Spring AI's MCP client modules to structure and send context-rich requests to the server.

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


### MCP Server Endpoints (examples)
- `GET /api/patients` - List all patients
- `POST /api/patients` - Create a new patient
- `GET /api/reports` - List all medical reports
- `POST /api/reports` - Create a new medical report
- `POST /api/ai/infer` - Send context to AI model using MCP (example)

(See controller classes and Spring AI MCP documentation for full details.)

---

## License


This project is licensed under the MIT License.
