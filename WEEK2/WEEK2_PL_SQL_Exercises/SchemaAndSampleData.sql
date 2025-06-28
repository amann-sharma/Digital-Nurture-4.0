-- SCHEMA AND SAMPLE DATA FOR PL/SQL EXERCISES (with Indian Names)
-- This script drops existing tables (if any), creates all required tables, and inserts sample data.
-- Run this script in Oracle Live SQL before running your PL/SQL exercises.

-- =========================
-- 1. DROP TABLES (for reruns)
-- =========================
BEGIN EXECUTE IMMEDIATE 'DROP TABLE AuditLog'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Transactions'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Accounts'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Loans'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Employees'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE Customers'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

-- =========================
-- 2. CREATE TABLES
-- =========================

-- Customers table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    DOB DATE NOT NULL,
    Balance NUMBER DEFAULT 0,
    LastModified DATE,
    IsVIP CHAR(10) DEFAULT 'FALSE' CONSTRAINT CHK1 CHECK(IsVIP IN ('TRUE','FALSE'))
);

-- Employees table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Accounts table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER NOT NULL,
    AccountType VARCHAR2(20),
    Balance NUMBER DEFAULT 0,
    LastModified DATE,
    CONSTRAINT fk_accounts_customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Loans table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER NOT NULL,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    CONSTRAINT fk_loans_customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Transactions table
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER NOT NULL,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    CONSTRAINT fk_transactions_account FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

-- AuditLog table (for triggers)
CREATE TABLE AuditLog (
    LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TransactionID NUMBER,
    LogDate DATE DEFAULT SYSDATE,
    Action VARCHAR2(100)
);

-- =========================
-- 3. INSERT SAMPLE DATA (with Indian Names)
-- =========================

-- Customers
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'Amit Sharma', TO_DATE('1982-03-10', 'YYYY-MM-DD'), 12000, SYSDATE, 'TRUE');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (2, 'Priya Singh', TO_DATE('1995-08-15', 'YYYY-MM-DD'), 9500, SYSDATE, 'FALSE');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (3, 'Rahul Verma', TO_DATE('1970-12-01', 'YYYY-MM-DD'), 25000, SYSDATE, 'TRUE');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (4, 'Sneha Iyer', TO_DATE('1992-05-22', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');

-- Employees
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Rohit Mehra', 'Manager', 85000, 'HR', TO_DATE('2012-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Anjali Desai', 'Developer', 70000, 'IT', TO_DATE('2016-03-20', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (3, 'Vikram Patel', 'Analyst', 60000, 'Finance', TO_DATE('2018-11-05', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (4, 'Meena Nair', 'Tester', 55000, 'QA', TO_DATE('2019-09-12', 'YYYY-MM-DD'));

-- Accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 12000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 9500, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (3, 3, 'Savings', 25000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (4, 4, 'Recurring', 8000, SYSDATE);

-- Loans
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 3, 10000, 6, SYSDATE, ADD_MONTHS(SYSDATE, 36));

-- Transactions
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 2000, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 1500, 'Withdrawal');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (3, 3, SYSDATE, 5000, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (4, 4, SYSDATE, 1000, 'Deposit');

-- =========================
-- 4. CHECK TABLES
-- =========================
-- You can run these queries to verify:
-- SELECT * FROM Customers;
-- SELECT * FROM Employees;
-- SELECT * FROM Accounts;
-- SELECT * FROM Loans;
-- SELECT * FROM Transactions;
-- SELECT * FROM AuditLog; 