-- Exercise 1: Control Structures - Scenario 1
-- Apply 1% discount to loan interest rates for customers above 60 years old
-- (See detailed comments in script)

SET SERVEROUTPUT ON;
DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM DOB) AS age
        FROM Customers;
    var_customer_id Customers.CustomerID%TYPE;
    var_age NUMBER;
BEGIN
    FOR customer_record IN customer_cursor LOOP
        var_customer_id := customer_record.CustomerID;
        var_age := customer_record.age;
        IF var_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = var_customer_id;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer with CustomerID: ' || var_customer_id || ' is of age: ' || var_age);
            DBMS_OUTPUT.PUT_LINE('No change in loan');
        END IF;
    END LOOP;
    COMMIT;
END;
/ 