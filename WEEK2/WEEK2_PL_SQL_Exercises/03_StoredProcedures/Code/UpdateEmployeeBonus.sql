-- Scenario 2: Implement a bonus scheme for employees based on their performance
-- This procedure updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN Employees.Department%TYPE,
    p_bonus_percentage IN NUMBER
) AS
    v_count NUMBER := 0;
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100),
        HireDate = SYSDATE
    WHERE Department = p_department;
    v_count := SQL%ROWCOUNT;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus applied to employees in the ' || p_department || ' department. Rows affected: ' || v_count);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
END UpdateEmployeeBonus;
/

-- Example usage:
-- EXEC UpdateEmployeeBonus('IT', 5);
-- EXEC UpdateEmployeeBonus('HR', 3);
-- SELECT * FROM Employees; 