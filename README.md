# Customer-Service

This repository contains the implementation of the `customer-service` microservice. This service manages customer data, including CRUD operations, data validation, and error handling. It is part of a broader architecture that adheres to clean code principles for maintainability and scalability. The deployment options include running locally or within Docker containers.

## Project Structure Overview

This project follows a layered architecture, ensuring separation of concerns and easy extensibility. It includes the following layers:

- **Domain Layer**: Contains the core business logic and entities.
- **Application Layer**: Implements the use cases for customer management.
- **Infrastructure Layer**: Handles database interactions using JPA.
- **Presentation Layer**: Manages incoming HTTP requests and routes them to the appropriate handlers.

## Deployment

To deploy and run the `customer-service` microservice, you have two flexible options:

- **Docker Containers**: Ideal for a seamless and isolated runtime environment.
- **Local Setup**: Perfect for development and debugging directly on your machine, while still using Docker for infrastructure services.

### Prerequisites
Before proceeding, make sure the following are installed and configured:

- **Docker** and **Docker Compose**
- **JDK 17**

### Running with Docker Containers

To deploy the `customer-service` microservice using Docker containers, follow these steps:

#### Step 1: Set up the infrastructure
1. Download the `docker-compose-infra.yml` file from the link below and place it in the root directory of your project:
    - [Docker Compose Infra File](https://drive.google.com/file/d/1Bg2flsdO9lvctRw8aGa2FfUuQln8GULX/view?usp=sharing)

2. Run the following command to start the required infrastructure services (e.g., PostgreSQL):
   ```bash
   docker-compose -f docker-compose-infra.yml up -d
   docker network create bank_network
   docker network connect bank_network postgres
   ```

#### Step 2: Build and Run the `customer-service` Docker container
1. In the root directory of the `customer-service` microservice, execute the following commands:
   ```bash
   # Build the project using Gradle
   ./gradlew clean build

   # Ensure any previous Docker containers and volumes are removed
   docker-compose down --volumes --remove-orphans

   # Build and start the Docker containers
   docker-compose up --build
   ```

2. Once the container is running, the service will be available at:
   http://localhost:3000/customer
---

### Running Locally

To run the `customer-service` microservice locally, follow these steps:

1. Make sure you are on the `developer` branch:
   ```bash
   git checkout developer
   ```

2. In the root directory of the `customer-service` microservice, execute the following commands to build and run the application:
   ```bash
   # Build the project using Gradle
   ./gradlew clean build

   # Run the application locally
   ./gradlew bootRun
   ```

3. Once the application is running, it will be accessible at:
   http://localhost:3000/customer
---

## Postman Collection

You can find the Postman collection for testing the `account-service` endpoints at the link below:

- [Bank Customer Collection](https://drive.google.com/file/d/1QjG2CYQyiCxODFBCNd6OAnQtcN9-C5QI/view?usp=sharing)

---

## CustomerController

The `CustomerController` is a Spring Boot REST controller that exposes CRUD operations for managing customer data. It acts as an intermediary between the API requests and the business logic, delegating the actual operations to the `CrudCustomerUseCase`.

#### Endpoints:
- **POST /customer**:
    - Creates a new customer.
    - Takes a `CustomerDTO` as input and returns the created customer.

- **GET /customer/{id}**:
    - Retrieves a specific customer by their ID.
    - Returns the customer data in the form of a `CustomerDTO`.

- **PUT /customer/{id}**:
    - Updates an existing customer by their ID.
    - Accepts a `CustomerDTO` and returns the updated customer data.

- **DELETE /customer/{id}**:
    - Deletes a customer by their ID.
    - Responds with a `204 No Content` status if successful.

- **GET /customer**:
    - Retrieves a list of all customers.
    - Returns the customers as a list of `CustomerDTO` objects.


---
All rights reserved © 2024 Roger Laza. Unauthorized use, distribution, or reproduction of any part of this material is strictly prohibited.
