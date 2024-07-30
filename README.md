# Job App

## Overview
The Job App is a comprehensive application designed to manage companies, job listings, and company reviews. It allows users to perform CRUD (Create, Read, Update, Delete) operations on companies, jobs, and reviews, providing a robust platform for job seekers and employers alike. This project leverages Spring Boot, Maven, PostgreSQL, and Docker, with future plans to evolve into a microservices architecture.

## Key Features
1. **Company Management**: 
   - Add, update, view, and delete company details.
   - Retrieve detailed information about specific companies.

2. **Job Listings**:
   - Post, update, view, and delete job listings associated with companies.
   - Fetch detailed job descriptions and requirements.

3. **Company Reviews**:
   - Submit, edit, view, and remove reviews for companies.
   - Aggregate reviews to provide an overall company rating.

## Technology Stack
- **Backend**: Spring Boot
  - Utilizes Spring Boot for building the RESTful API.
  - JPA (Java Persistence API) for data persistence.

- **Build Tool**: Maven
  - Dependency management and project build automation using Apache Maven 3.9.8.

- **Database**: PostgreSQL
  - PostgreSQL for database management, ensuring reliable and scalable data storage.

- **Database Management**: pgAdmin
  - pgAdmin for managing PostgreSQL databases.

- **Containerization**: Docker
  - Docker for containerizing the application, ensuring consistency across different environments.
  - Includes Docker images for PostgreSQL and pgAdmin.

## Project Structure
The project is organized into a structured format, adhering to best practices for Spring Boot applications:

- **src/main/java/com/thiru/JobApp**:
  - Contains the main application class `JobAppApplication.java`.
  - Includes various packages for controllers, services, repositories, and models.

- **src/main/resources**:
  - `application.properties`: Configuration file for the application.

- **src/test/java/com/thiru/JobApp**:
  - Contains unit and integration tests to ensure the application's functionality.

## Future Plans
- **Microservices Architecture**:
  - Transitioning to a microservices architecture to enhance scalability and maintainability.
  - Each module (companies, jobs, reviews) will be developed as an independent microservice.

## Getting Started
1. **Clone the repository**:
   ```sh
   git clone https://github.com/Thiruvalluan10/JobApp.git
   cd JobApp
