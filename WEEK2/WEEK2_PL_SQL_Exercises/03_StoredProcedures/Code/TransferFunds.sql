-- Scenario 3: Customers should be able to transfer funds between their accounts
-- This procedure transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.

SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id IN Accounts.AccountID%TYPE,
    p_to_account_id IN Accounts.AccountID%TYPE,
    p_amount IN NUMBER
) AS
    v_from_balance Accounts.Balance%TYPE;
BEGIN
    -- Fetch the current balance of the source account
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id FOR UPDATE;

    -- Check for sufficient funds
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;

    -- Perform the transfer
    UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_from_account_id;
    UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_to_account_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer of ' || p_amount || ' from account ' || p_from_account_id || ' to account ' || p_to_account_id || ' completed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END TransferFunds;
/

-- Example usage:
-- EXEC TransferFunds(1, 2, 100);
-- SELECT * FROM Accounts; 