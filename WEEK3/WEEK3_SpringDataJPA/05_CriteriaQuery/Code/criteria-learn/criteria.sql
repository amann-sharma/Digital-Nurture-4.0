-- Create the criteria schema
CREATE SCHEMA IF NOT EXISTS criteria;

-- Use the criteria schema
USE criteria;

-- Create department table
CREATE TABLE IF NOT EXISTS department (
    dp_id INT NOT NULL AUTO_INCREMENT,
    dp_name VARCHAR(50),
    PRIMARY KEY (dp_id)
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

-- Insert department data
INSERT INTO department (dp_name) VALUES ('Technology');
INSERT INTO department (dp_name) VALUES ('Human Resources');
INSERT INTO department (dp_name) VALUES ('Finance');
INSERT INTO department (dp_name) VALUES ('Marketing');
INSERT INTO department (dp_name) VALUES ('Operations');

-- Insert employee data
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('John Smith', 75000.0, true, '1990-05-15', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
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

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('James Thompson', 95000.0, true, '1984-02-28', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Maria Garcia', 62000.0, true, '1990-10-05', 2);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Daniel Lee', 88000.0, true, '1986-07-17', 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Jessica White', 73000.0, false, '1991-12-22', 3);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Kevin Miller', 82000.0, true, '1988-03-14', 1);

-- Insert some employees with NULL date of birth for testing NULL conditions
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Alex Johnson', 75000.0, true, NULL, 1);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES ('Rachel Green', 65000.0, false, NULL, 2); 