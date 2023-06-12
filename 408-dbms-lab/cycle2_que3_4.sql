-- Create stored procedure for didplaying fibonacci series upto 'n' number

CREATE PROCEDURE GenerateFibonacciSeries
  @n INT
AS
BEGIN
  -- Variable declarations
  DECLARE @a INT = 0;
  DECLARE @b INT = 1;
  DECLARE @fib INT = 0;
  DECLARE @counter INT = 1;

  -- Check for invalid input
  IF @n <= 0
  BEGIN
    PRINT 'Invalid input. Please provide a positive integer value for n.';
    RETURN;
  END

  -- Print the Fibonacci series
  WHILE @counter <= @n
  BEGIN
    PRINT @fib;
    SET @fib = @a + @b;
    SET @a = @b;
    SET @b = @fib;
    SET @counter = @counter + 1;
  END
END


EXEC GenerateFibonacciSeries @n = 10;

----------------------------------------------------------------------
----------------------------------------------------------------------
----------------------------------------------------------------------

-- Create stored procedure for displaying even and odd numbers upto 'n' elements using temporary table.

CREATE PROCEDURE GenerateEvenAndOddNumbers
  @n INT
AS
BEGIN
  -- Create a temporary table
  CREATE TABLE #Numbers (
    Number INT
  );

  -- Check for invalid input
  IF @n <= 0
  BEGIN
    PRINT 'Invalid input. Please provide a positive integer value for n.';
    RETURN;
  END

  -- Insert even and odd numbers into the temporary table
  DECLARE @counter INT = 1;

  WHILE @counter <= @n
  BEGIN
    INSERT INTO #Numbers (Number)
    VALUES (@counter);

    SET @counter = @counter + 1;
  END

  -- Display even numbers
  SELECT Number
  FROM #Numbers
  WHERE Number % 2 = 0;

  PRINT ''; -- Print a newline between even and odd numbers

  -- Display odd numbers
  SELECT Number
  FROM #Numbers
  WHERE Number % 2 <> 0;

  -- Drop the temporary table
  DROP TABLE #Numbers;
END



EXEC GenerateEvenAndOddNumbers @n = 10;


