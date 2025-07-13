-- Create the ormlearn schema
CREATE SCHEMA IF NOT EXISTS ormlearn;

-- Use the ormlearn schema
USE ormlearn;

-- Create department table
CREATE TABLE IF NOT EXISTS department (
    dp_id INT NOT NULL AUTO_INCREMENT,
    dp_name VARCHAR(50),
    PRIMARY KEY (dp_id)
);

-- Create skill table
CREATE TABLE IF NOT EXISTS skill (
    sk_id INT NOT NULL AUTO_INCREMENT,
    sk_name VARCHAR(50),
    PRIMARY KEY (sk_id)
);

-- Create employee table
CREATE TABLE IF NOT EXISTS employee (
    em_id INT NOT NULL AUTO_INCREMENT,
    em_name VARCHAR(50),
    em_salary DOUBLE,
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    PRIMARY KEY (em_id),
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

-- Create employee_skill junction table
CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Insert department data
INSERT INTO department (dp_name) VALUES ('Technology');
INSERT INTO department (dp_name) VALUES ('Human Resources');
INSERT INTO department (dp_name) VALUES ('Finance');
INSERT INTO department (dp_name) VALUES ('Marketing');
INSERT INTO department (dp_name) VALUES ('Operations');

-- Insert skill data
INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('Spring Boot');
INSERT INTO skill (sk_name) VALUES ('Hibernate');
INSERT INTO skill (sk_name) VALUES ('MySQL');
INSERT INTO skill (sk_name) VALUES ('JavaScript');
INSERT INTO skill (sk_name) VALUES ('React');
INSERT INTO skill (sk_name) VALUES ('Python');
INSERT INTO skill (sk_name) VALUES ('Data Analysis');
INSERT INTO skill (sk_name) VALUES ('Project Management');
INSERT INTO skill (sk_name) VALUES ('Communication');

-- Insert employee data
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('John Smith', 75000.0, true, '1990-05-15', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, true, em_date_of_birth, em_dp_id) 
VALUES ('Sarah Johnson', 65000.0, true, '1988-12-03', 2);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Michael Brown', 80000.0, true, '1985-08-22', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Emily Davis', 70000.0, false, '1992-03-10', 3);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('David Wilson', 90000.0, true, '1983-11-18', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Lisa Anderson', 60000.0, true, '1991-07-25', 4);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Robert Taylor', 85000.0, true, '1987-04-12', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Jennifer Martinez', 72000.0, true, '1989-09-30', 2);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Christopher Garcia', 78000.0, true, '1986-01-08', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Amanda Rodriguez', 68000.0, false, '1993-06-14', 5);

-- Insert employee-skill relationships
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1); -- John Smith - Java
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2); -- John Smith - Spring Boot
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 3); -- John Smith - Hibernate

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 9); -- Sarah Johnson - Project Management
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 10); -- Sarah Johnson - Communication

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 1); -- Michael Brown - Java
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 4); -- Michael Brown - MySQL
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 5); -- Michael Brown - JavaScript

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (4, 8); -- Emily Davis - Data Analysis

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (5, 1); -- David Wilson - Java
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (5, 2); -- David Wilson - Spring Boot
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (5, 3); -- David Wilson - Hibernate
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (5, 4); -- David Wilson - MySQL

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (6, 9); -- Lisa Anderson - Project Management
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (6, 10); -- Lisa Anderson - Communication

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (7, 1); -- Robert Taylor - Java
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (7, 5); -- Robert Taylor - JavaScript
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (7, 6); -- Robert Taylor - React

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (8, 9); -- Jennifer Martinez - Project Management
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (8, 10); -- Jennifer Martinez - Communication

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (9, 1); -- Christopher Garcia - Java
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (9, 2); -- Christopher Garcia - Spring Boot
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (9, 7); -- Christopher Garcia - Python

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (10, 9); -- Amanda Rodriguez - Project Management 