# Week 5 - Microservices with Spring Boot 3 and Spring Cloud

## Overview
This week covers the implementation of microservices architecture using Spring Boot 3 and Spring Cloud. The exercises include creating individual microservices, setting up service discovery with Eureka, and implementing an API Gateway for routing requests.

## Completed Components

### 1. Eureka Discovery Server (Port: 8761)
- **Location**: `WEEK5_Microservices/eureka-discovery-server/`
- **Purpose**: Service registry that holds information about all available microservices
- **Access URL**: http://localhost:8761
- **Key Features**:
  - Central service registry
  - Service health monitoring
  - Dynamic service discovery

### 2. Account Microservice (Port: 8080)
- **Location**: `WEEK5_Microservices/account-service/`
- **Purpose**: Handles account-related operations
- **Endpoints**:
  - `GET /accounts/{number}` - Get account details
- **Sample Response**:
  ```json
  {
    "number": "00987987973432",
    "type": "savings", 
    "balance": 234343
  }
  ```

### 3. Loan Microservice (Port: 8081)
- **Location**: `WEEK5_Microservices/loan-service/`
- **Purpose**: Handles loan-related operations
- **Endpoints**:
  - `GET /loans/{number}` - Get loan details
- **Sample Response**:
  ```json
  {
    "number": "H00987987972342",
    "type": "car",
    "loan": 400000,
    "emi": 3258,
    "tenure": 18
  }
  ```

### 4. Greet Service (Port: 8083)
- **Location**: `WEEK5_Microservices/greet-service/`
- **Purpose**: Simple greeting service for demonstration
- **Endpoints**:
  - `GET /greet` - Returns "Hello World"

### 5. API Gateway (Port: 9090)
- **Location**: `WEEK5_Microservices/api-gateway/`
- **Purpose**: Single entry point for all microservices
- **Features**:
  - Request routing to appropriate microservices
  - Load balancing using Eureka service discovery
  - Global request/response logging filter
- **Routes**:
  - `/accounts/**` → account-service
  - `/loans/**` → loan-service
  - `/greet/**` → greet-service

## Architecture Overview

```
[Client] → [API Gateway:9090] → [Service Discovery:8761]
                ↓
    ┌─────────────────────────────────┐
    ↓                ↓                ↓
[Account:8080]  [Loan:8081]  [Greet:8083]
```

## How to Run

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Startup Sequence
1. **Start Eureka Discovery Server first**:
   ```bash
   cd WEEK5_Microservices/eureka-discovery-server
   mvn spring-boot:run
   ```
   Wait for complete startup, then verify at http://localhost:8761

2. **Start individual microservices**:
   ```bash
   # Account Service
   cd WEEK5_Microservices/account-service
   mvn spring-boot:run
   
   # Loan Service  
   cd WEEK5_Microservices/loan-service
   mvn spring-boot:run
   
   # Greet Service
   cd WEEK5_Microservices/greet-service
   mvn spring-boot:run
   ```

3. **Start API Gateway last**:
   ```bash
   cd WEEK5_Microservices/api-gateway
   mvn spring-boot:run
   ```

### Testing the Implementation

#### Direct Service Access:
- Account: http://localhost:8080/accounts/123456
- Loan: http://localhost:8081/loans/789012
- Greet: http://localhost:8083/greet

#### Through API Gateway:
- Account: http://localhost:9090/accounts/123456
- Loan: http://localhost:9090/loans/789012  
- Greet: http://localhost:9090/greet

#### Service Discovery:
- Eureka Dashboard: http://localhost:8761
- Should show all registered services

## Key Learning Objectives Achieved

✅ **Microservices Architecture**: Understanding the shift from monolithic to microservices architecture

✅ **Service Creation**: Created multiple independent Spring Boot microservices

✅ **Service Discovery**: Implemented Eureka server for dynamic service registration and discovery

✅ **API Gateway**: Set up Spring Cloud Gateway for request routing and cross-cutting concerns

✅ **Load Balancing**: Configured client-side load balancing using service discovery

✅ **Global Filters**: Implemented request logging using global filters

✅ **Configuration Management**: Proper configuration of ports, service names, and Eureka integration

## Technologies Used
- Spring Boot 3.5.3
- Spring Cloud 2024.0.0
- Spring Cloud Gateway
- Netflix Eureka
- Maven
- Java 17

## Week 5 Mandatory Exercises Status
- ✅ Creating Microservices for account and loan
- ✅ Create Eureka Discovery Server and register microservices  
- ✅ Create Spring Cloud API Gateway with routing
- ✅ Implement global filter for request logging
- ✅ Test all services through gateway and direct access

## Next Steps
Week 5 microservices implementation is **COMPLETE**. All mandatory exercises have been implemented and tested.

Ready to proceed to Week 6 (React) when needed.
