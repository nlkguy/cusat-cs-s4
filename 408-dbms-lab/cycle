-- (Implementation of nested queries)
-- Create two tables Account and Transactions
A-- ccount:acc_no,acc_name,balance
-- Transactions:Tran Id, Acc No, Trans Date, Amount, Trans Type
-- a) List the account details of account holders who have highest balance.
-- b)List the name of customers who made more than 2 transactions in a week.
-- c)List the name and balance of customers who made withdrawal amount more than 2500 in current month.
-- d)List the name of employee who didn’t make any transactions in current month.

-- Create the Account table
CREATE TABLE Account (
  acc_no INT PRIMARY KEY,
  acc_name VARCHAR(100),
  balance DECIMAL(10, 2)
);

-- Create the Transactions table
CREATE TABLE Transactions (
  Tran_Id INT PRIMARY KEY,
  Acc_No INT,
  Trans_Date DATE,
  Amount DECIMAL(10, 2),
  Trans_Type VARCHAR(20),
  FOREIGN KEY (Acc_No) REFERENCES Account(acc_no)
);

-- Insert sample data into the Account table
INSERT INTO Account (acc_no, acc_name, balance)
VALUES
  (1, 'John Doe', 5000.00),
  (2, 'Jane Smith', 7500.00),
  (3, 'David Johnson', 3000.00);

-- Insert sample data into the Transactions table
INSERT INTO Transactions (Tran_Id, Acc_No, Trans_Date, Amount, Trans_Type)
VALUES
  (1, 1, '2023-06-01', 1000.00, 'Deposit'),
  (2, 1, '2023-06-03', 500.00, 'Withdrawal'),
  (3, 2, '2023-06-04', 2000.00, 'Deposit'),
  (4, 2, '2023-06-07', 1000.00, 'Withdrawal'),
  (5, 3, '2023-06-10', 5000.00, 'Withdrawal'),
  (6, 3, '2023-06-12', 1000.00, 'Withdrawal');

-- a) List the account details of account holders who have the highest balance
SELECT acc_no, acc_name, balance
FROM Account
WHERE balance = (SELECT MAX(balance) FROM Account);

-- b) List the name of customers who made more than 2 transactions in a week
SELECT acc_name
FROM Account
WHERE acc_no IN (
  SELECT Acc_No
  FROM Transactions
  WHERE Trans_Date BETWEEN DATEADD(DAY, -7, GETDATE()) AND GETDATE()
  GROUP BY Acc_No
  HAVING COUNT(*) > 2
);

-- c) List the name and balance of customers who made a withdrawal amount more than 2500 in the current month
SELECT acc_name, balance
FROM Account
WHERE acc_no IN (
  SELECT Acc_No
  FROM Transactions
  WHERE Trans_Date >= DATEFROMPARTS(YEAR(GETDATE()), MONTH(GETDATE()), 1)
    AND Trans_Type = 'Withdrawal'
  GROUP BY Acc_No
  HAVING SUM(Amount) > 2500
);

-- d) List the name of employees who didn’t make any transactions in the current month
SELECT acc_name
FROM Account
WHERE acc_no NOT IN (
  SELECT DISTINCT Acc_No
  FROM Transactions
  WHERE YEAR(Trans_Date) = YEAR(GETDATE()) AND MONTH(Trans_Date) = MONTH(GETDATE())
);
