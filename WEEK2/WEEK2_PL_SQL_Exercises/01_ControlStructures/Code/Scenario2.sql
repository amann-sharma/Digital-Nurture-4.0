-- Exercise 1: Control Structures - Scenario 2
-- Promote customers to VIP if balance > 10,000
-- (See detailed comments in script)

ALTER TABLE Customers ADD IsVIP CHAR(10) CONSTRAINT CHK1 CHECK(IsVIP IN ('TRUE','FALSE'));

SET SERVEROUTPUT ON;
DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;
    var_customer_id Customers.CustomerID%TYPE;
    var_balance Customers.Balance%TYPE;
BEGIN
    FOR customer_record IN customer_cursor LOOP
        var_customer_id := customer_record.CustomerID;
        var_balance := customer_record.Balance;
        IF var_balance > 10000 THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || var_customer_id || ' has balance greater than 10000');
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = var_customer_id;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || var_customer_id || ' has balance less than 10000');
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = var_customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/ 