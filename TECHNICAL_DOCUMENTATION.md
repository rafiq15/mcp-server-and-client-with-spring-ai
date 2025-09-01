# Technical Documentation: Spring AI MCP Server

## Overview
The **Spring AI MCP Server** is a Spring Boot RESTful API backend for managing medical reports and patient data. It follows a layered architecture and uses JPA for data persistence.

## Main Components

### 1. Entities (`entity/`)
- **Patient.java**: Represents a patient with fields such as id, name, etc.
- **MedicalReport.java**: Represents a medical report linked to a patient.

### 2. DTOs (`dto/`)
- **PatientDTO.java**: Data Transfer Object for patient data.
- **MedicalReportDTO.java**: DTO for medical report data.

### 3. Repositories (`repository/`)
- **PatientRepository.java**: Spring Data JPA repository for `Patient`.
- **MedicalReportRepository.java**: Repository for `MedicalReport`.

### 4. Services (`service/`)
- **MedicalService.java**: Contains business logic for managing patients and reports. Handles CRUD operations and custom logic. Includes exception handling (e.g., `NotFoundException`).

### 5. Application Entry Point
- **SpringAiMcpServerApplication.java**: Main class to bootstrap the server.

### 6. Configuration
- **application.yaml**: Configures server port, database, and other properties.

## API Design
- RESTful endpoints for CRUD operations on patients and medical reports.
- Uses DTOs for request/response payloads.
- Exception handling for not found and validation errors.

## How It Works
1. **Controller** (if present): Receives HTTP requests, maps to service methods.
2. **Service**: Implements business logic, interacts with repositories.
3. **Repository**: Handles database operations.
4. **Entity/DTO**: Data model and transfer objects.

## Example Flow
- `POST /api/patients` → Controller → MedicalService.createPatient() → PatientRepository.save()

## Extensibility
- Add new entities, DTOs, or endpoints by following the existing structure.
- Configuration via `application.yaml`.

---

# Technical Documentation: Spring AI MCP Client

## Overview
The **Spring AI MCP Client** is a Spring Boot application that acts as a consumer of the server's REST APIs. It may provide a web UI or further REST endpoints for end-users.

## Main Components

### 1. Controllers (`controller/`)
- **MedicalController.java**: Handles client-side endpoints or UI logic. Consumes server APIs.

### 2. Application Entry Point
- **SpringAiMcpClientApplication.java**: Main class to bootstrap the client.

### 3. Configuration
- **application.yaml**: Configures client properties, such as the server URL.

## How It Works
1. **Controller**: Handles user requests or UI actions.
2. **RestTemplate/WebClient** (if used): Sends HTTP requests to the server.
3. **Configuration**: Set server URL and other properties in `application.yaml`.

## Extensibility
- Add new controllers or UI features as needed.
- Update configuration for new server endpoints.

---

## Contact

---

# Deployment Process

## Prerequisites
- Java 17 or higher
- Gradle 7 or higher
- (Optional) Docker for containerized deployment
- Ollama or Llama model server running (for AI model integration)

## Steps
1. **Build the Server and Client**
	- Navigate to each module directory:
	  ```powershell
	  ./gradlew build
	  ```
2. **Configure AI Model (Llama/Ollama)**
	- Ensure the Ollama server is running and the Llama model is available.
	- Update `application.yaml` in both server and client to point to the correct AI model endpoint.
3. **Run the Applications**
	- Start the server:
	  ```powershell
	  ./gradlew bootRun
	  ```
	- Start the client:
	  ```powershell
	  ./gradlew bootRun
	  ```
4. **(Optional) Docker Deployment**
	- Create Dockerfiles for both modules.
	- Build and run containers as needed.

---

# System Architecture Diagram

Below is a conceptual diagram of the system architecture:

```mermaid
graph TD
	 A[MCP Client] -- HTTP REST --> B[MCP Server]
	 B -- HTTP/gRPC --> C[AI Model (Llama/Ollama)]
	 B -- DB Access --> D[(Database)]
```

- **MCP Client**: Sends requests to the server, may provide UI or API.
- **MCP Server**: Handles business logic, persists data, and communicates with the AI model.
- **AI Model**: Llama/Ollama model server, provides AI inference.
- **Database**: Stores patient and report data.

---

For questions or contributions, please open an issue or pull request.
