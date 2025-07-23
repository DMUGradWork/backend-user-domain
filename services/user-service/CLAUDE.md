# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a user service microservice built with Spring Boot 3.5.3 and Java 21 as part of a larger MSA (Microservice Architecture) system called "grewmeet". The service handles user management and profile operations with event-driven communication via Apache Kafka.

## Build System & Commands

**Build Tool:** Gradle with Wrapper
- Build: `./gradlew build`
- Run tests: `./gradlew test`
- Run application: `./gradlew bootRun`
- Clean build: `./gradlew clean build`

## Architecture Overview

### Domain Structure
The codebase follows Domain-Driven Design (DDD) principles with clear separation of concerns:

- **Core Domain** (`com.grewmeet.user.core`): Contains the User entity, repository, and base domain objects
- **Profile Domain** (`com.grewmeet.user.profile`): Handles profile management with event consumption from Kafka
- **Saga Pattern** (`com.grewmeet.user.saga`): Event-driven communication with other microservices

### Event-Driven Architecture
- Uses Spring Kafka for asynchronous communication
- Consumes `UserRegisteredEvent` from auth service to create user profiles
- Custom Kafka configuration in `CustomKafkaProperties`
- Event consumers are grouped under "user-service-group"

### Key Components
- **User Entity**: Core domain entity with audit fields (createdAt, updatedAt, version)
- **Profile Management**: Separate bounded context for user profile operations
- **Event Consumers**: Kafka listeners for inter-service communication
- **Repository Pattern**: Spring Data JPA repositories for data access

## Technology Stack
- Spring Boot 3.5.3
- Spring Security
- Spring Data JPA 
- Spring Kafka
- MySQL database
- Lombok for boilerplate reduction
- OpenAPI/Swagger for API documentation

## Development Notes
- Uses Java 21 features and records (e.g., UserRegisteredEvent)
- JPA entities follow best practices with proper equals/hashCode
- Event handling includes error logging and exception handling
- Password fields are properly marked with @JsonIgnore for security