# Spring Data JPA Quick Example

## Setup Instructions

### 1. Database Setup
1. Start MySQL server
2. Execute the SQL script to create database and tables:
   ```sql
   source country_table.sql
   ```

### 2. Run the Application
1. Navigate to the project directory
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### 3. Expected Output
The application will:
- Load Spring context
- Connect to MySQL database
- Retrieve all countries from the database
- Display the results in logs

### 4. Database Configuration
- Database: ormlearn
- Username: root
- Password: root
- Table: country

### 5. Features Demonstrated
- Spring Boot with Spring Data JPA
- Entity mapping with JPA annotations
- Repository pattern
- Transaction management
- Database connectivity with MySQL 