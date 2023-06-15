-- 1. Create a procedure to calculate electricity bill of a consumer.
-- Consumer table: Id, Name, Address Last Reading, Current Reading, Month, Year, Unit Charge
-- (default Rs 2).
-- Calculate the electricity bill by passing Consumer Id and Current Reading as argument . Display ID,
-- Name, Last Date of Payment(within 10days), Consumed Units in current month, and Charge.
-- 2. Create a procedure to find the grade of a student using cursor.
-- Student Table: Roll Number, Name, 6 Marks.
--  If Total mark>480 then A grade
--  Total mark>400 then B+ grade
--  Total mark>360 then B grade
--  Total mark>300 then C grade
--  Else Failed F.
-- 3. Create a Trigger to update the value of account balance as per the transaction. If transaction
-- is deposit then add amount to the existing balance. If transaction is withdrawal then deduct
-- the amount from balance.



-- 1)

CREATE TABLE Consumer (
  Id INT PRIMARY KEY,
  Name TEXT,
  Address TEXT,
  Last_Reading INT,
  Current_Reading INT,
  Month TEXT,
  Year INT,
  Unit_Charge DECIMAL DEFAULT 2.0
);

INSERT INTO Consumer (Id, Name, Address, Last_Reading, Current_Reading, Month, Year)
VALUES
  (1, 'Sheikh Abdullah', 'Petta,Trivandrum', 100, 150, 'June', 2023),
  (2, 'Varun Prabhakar', 'Aluva,Ernakulam', 200, 250, 'June', 2023);


CREATE PROCEDURE CalculateElectricityBill(
  IN consumerId INT,
  IN currentReading INT
)
BEGIN
  DECLARE lastReading INT;
  DECLARE unitCharge DECIMAL;
  DECLARE consumedUnits INT;
  DECLARE charge DECIMAL;
  DECLARE lastPaymentDate DATE;

  -- Retrieve the necessary data from the Consumer table
  SELECT Last_Reading, Unit_Charge, Month, Year
  INTO lastReading, unitCharge, @month, @year
  FROM Consumer
  WHERE Id = consumerId;

  -- Calculate the consumed units and charge
  SET consumedUnits = currentReading - lastReading;
  SET charge = consumedUnits * unitCharge;

  -- Calculate the last payment date (assuming current date as the reference)
  SET lastPaymentDate = DATE_ADD(DATE_FORMAT(NOW(), '%Y-%m-01'), INTERVAL 10 DAY);

  -- Display the calculated information
  SELECT
    Id,
    Name,
    DATE_FORMAT(lastPaymentDate, '%Y-%m-%d') AS Last_Payment_Date,
    consumedUnits AS Consumed_Units,
    charge AS Charge
  FROM Consumer
  WHERE Id = consumerId;
END;



------------------------------------------------------------------

-- 2)


CREATE TABLE Student (
  Roll_Number INT PRIMARY KEY,
  Name TEXT,
  Mark1 INT,
  Mark2 INT,
  Mark3 INT,
  Mark4 INT,
  Mark5 INT,
  Mark6 INT
);

INSERT INTO Student (Roll_Number, Name, Mark1, Mark2, Mark3, Mark4, Mark5, Mark6)
VALUES
  (1, 'Anu Sithara', 80, 90, 75, 85, 95, 70),
  (2, 'Murali Gopi', 70, 65, 80, 90, 85, 95);

DELIMITER //

CREATE PROCEDURE CalculateStudentGrade()
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE rollNumber INT;
  DECLARE name TEXT;
  DECLARE mark1 INT;
  DECLARE mark2 INT;
  DECLARE mark3 INT;
  DECLARE mark4 INT;
  DECLARE mark5 INT;
  DECLARE mark6 INT;
  DECLARE totalMarks INT;
  DECLARE grade CHAR(2);

  -- Declare the cursor
  DECLARE cur CURSOR FOR SELECT Roll_Number, Name, Mark1, Mark2, Mark3, Mark4, Mark5, Mark6 FROM Student;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  -- Open the cursor
  OPEN cur;

  -- Loop through the student records
  student_loop: LOOP
    -- Fetch the next record
    FETCH cur INTO rollNumber, name, mark1, mark2, mark3, mark4, mark5, mark6;

    IF done THEN
      LEAVE student_loop;
    END IF;

    -- Calculate the total marks
    SET totalMarks = mark1 + mark2 + mark3 + mark4 + mark5 + mark6;

    -- Assign the grade based on the total marks
    IF totalMarks > 480 THEN
      SET grade = 'A';
    ELSEIF totalMarks > 400 THEN
      SET grade = 'B+';
    ELSEIF totalMarks > 360 THEN
      SET grade = 'B';
    ELSEIF totalMarks > 300 THEN
      SET grade = 'C';
    ELSE
      SET grade = 'F';
    END IF;

    -- Display the student's grade
    SELECT CONCAT('Roll Number: ', rollNumber) AS Result;
    SELECT CONCAT('Name: ', name) AS Result;
    SELECT CONCAT('Grade: ', grade) AS Result;
    SELECT '' AS Result; -- Add a line break between student records
  END LOOP;

  -- Close the cursor
  CLOSE cur;
END //

DELIMITER ;



-------------------------------------------------------------------

-- 3)


CREATE TABLE Account (
  Account_Number INT PRIMARY KEY,
  Account_Name TEXT,
  Balance DECIMAL(10, 2)
);

INSERT INTO Account (Account_Number, Account_Name, Balance)
VALUES
  (1, 'IG Geetha Prabhakar', 1000.00),
  (2, 'Abraham Khureshi', 500.00);

DELIMITER //


CREATE TRIGGER UpdateAccountBalance BEFORE INSERT ON Transaction
FOR EACH ROW
BEGIN
  DECLARE transactionType CHAR(10);
  DECLARE transactionAmount DECIMAL(10, 2);

  -- Retrieve the transaction type and amount from the inserted row
  SELECT Type, Amount INTO transactionType, transactionAmount FROM Transaction WHERE ID = NEW.ID;

  -- Update the account balance based on the transaction type
  IF transactionType = 'Deposit' THEN
    UPDATE Account SET Balance = Balance + transactionAmount WHERE Account_Number = NEW.Account_Number;
  ELSEIF transactionType = 'Withdrawal' THEN
    UPDATE Account SET Balance = Balance - transactionAmount WHERE Account_Number = NEW.Account_Number;
  END IF;
END //

DELIMITER ;
