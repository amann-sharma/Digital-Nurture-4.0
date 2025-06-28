-- Exercise 1: Control Structures - Scenario 3
-- Print reminders for loans due in the next 30 days
-- (See detailed comments in script)

SET SERVEROUTPUT ON;
DECLARE
    CURSOR cur_loans IS
        SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    v_loan_id Loans.LoanID%TYPE;
    v_customer_id Loans.CustomerID%TYPE;
    v_customer_name Customers.Name%TYPE;
    v_end_date Loans.EndDate%TYPE;
    v_found BOOLEAN := FALSE;
BEGIN
    OPEN cur_loans;
    LOOP
        FETCH cur_loans INTO v_loan_id, v_customer_id, v_customer_name, v_end_date;
        EXIT WHEN cur_loans%NOTFOUND;
        v_found := TRUE;
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || v_loan_id || ' for customer ' || v_customer_name || ' (ID: ' || v_customer_id || ') is due on ' || TO_CHAR(v_end_date, 'YYYY-MM-DD'));
    END LOOP;
    CLOSE cur_loans;
    IF NOT v_found THEN
        DBMS_OUTPUT.PUT_LINE('No loans are due within the next 30 days.');
    END IF;
END;
/ 