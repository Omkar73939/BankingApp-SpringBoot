# BankingApp-SpringBoot
Spring Boot backend application for banking with REST APIs, including account management and transaction operations, using MySQL.

# Banking System Backend

This is a Spring Boot backend application designed for a banking system. It provides RESTful APIs for managing bank accounts and performing transactions such as deposits and withdrawals.

## Features
- **Create Account**: Add a new bank account.
- **Delete Account**: Remove an account by its ID.
- **Get Account by ID**: Retrieve account details using the account ID.
- **Get All Accounts**: List all bank accounts.
- **Withdraw Money**: Deduct money from a specified account.
- **Deposit Money**: Add money to a specified account.

## Technologies Used
- **Spring Boot**: For building the RESTful APIs.
- **JPA/Hibernate**: For database interaction.
- **MySQL**: As the relational database.
- **Maven**: For project management.

## Project Structure
- **Entity Class**: Represents the bank account.
- **DTO (Data Transfer Object)**: Used for data exchange between layers.
- **Repository Layer**: Interfaces extending JPA Repository for CRUD operations.
- **Service Layer**: Contains business logic.
- **Controller Layer**: Exposes REST APIs to clients.

## Getting Started
1. Clone the repository.
2. Set up the MySQL database.
3. Update `application.properties` with your database configuration.
4. Build and run the application using Maven.

## How to Run
```bash
mvn spring-boot:run
