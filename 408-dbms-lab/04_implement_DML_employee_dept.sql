CREATE TABLE DEPARTMENT (
    DNO INT PRIMARY KEY,
    DNAME VARCHAR(50) NOT NULL,
    D_HOD VARCHAR(50)
);

CREATE TABLE EMPLOYEE (
    ENO INT PRIMARY KEY,
    ENAME VARCHAR(50) NOT NULL,
    SALARY FLOAT NOT NULL,
    DNO INT,
    MNGRNO INT,
    DOJ DATE,
    JOB VARCHAR(50),
    ADDRESS VARCHAR(100),
    CITY ENUM('KOCHI', 'MUMBAI', 'CHENNAI'),
    PINCODE VARCHAR(10),
    FOREIGN KEY (DNO) REFERENCES DEPARTMENT(DNO)
);

-- Insert some dummy data
INSERT INTO DEPARTMENT (DNO, DNAME, D_HOD) VALUES 
    (10, 'Sales', 'John Doe'),
    (20, 'Marketing', 'Jane Smith'),
    (30, 'Finance', 'Bob Johnson');

INSERT INTO EMPLOYEE (ENO, ENAME, SALARY, DNO, MNGRNO, DOJ, JOB, ADDRESS, CITY, PINCODE)
VALUES  (1, 'John Doe', 5000, 10, NULL, '2000-01-01', 'Manager', '123 Main St', 'KOCHI', '12345'),
        (2, 'Jane Smith', 6000, 20, 1, '2001-02-01', 'Manager', '456 Second St', 'MUMBAI', '23456'),
        (3, 'Bob Johnson', 7000, 30, 2, '2002-03-01', 'Worker', '789 Third St', 'CHENNAI', '34567'),
        (4, 'Alice Lee', 8000, 10, 1, '2003-04-01', 'Worker', '321 Fourth St', 'KOCHI', '45678'),
        (5, 'David Kim', 9000, 20, 2, '2004-05-01', 'Senior Clerk', '654 Fifth St', 'MUMBAI', '56789');

-- a. List the name of employee join after 1-1-1998 and working in Department 10
SELECT ENAME FROM EMPLOYEE WHERE DOJ > '1998-01-01' AND DNO = 10;

-- b. List all employees working in department other than department no 30
SELECT ENAME FROM EMPLOYEE WHERE DNO != 30;

-- c. List the name of employee working in department sales
SELECT ENAME FROM EMPLOYEE WHERE DNO = 10;

-- d. List the name of employee who doesn't have manager
SELECT ENAME FROM EMPLOYEE WHERE MNGRNO IS NULL;

-- e. List the employee whose name start with J and N as third character
SELECT ENAME FROM EMPLOYEE WHERE ENAME LIKE 'J_N%';

-- f. List all the employees join during the year 2000
SELECT ENAME FROM EMPLOYEE WHERE YEAR(DOJ) = 2000;

-- g. List the name of employee along with their annual salary and also for each record get the output EVERY YEAR<ENAME> EARNS<AMOUNT>
SELECT CONCAT(ENAME, ' EARN ', (SALARY * 12), ' RUPEES') AS EARNING_DETAILS FROM EMPLOYEE;

-- h. Find the total number of employee in EMPLOYEE table
SELECT COUNT(*) AS TOTAL_EMPLOYEES FROM EMPLOYEE;

-- i. Display the minimum salary of various categories of employee
SELECT JOB, MIN(SALARY) AS MIN_SALARY FROM EMPLOYEE GROUP BY JOB;

-- j. Display the minimum salary of various categories of employee in various department having minimum salary greater than 7000
SELECT JOB, MIN(SALARY) AS MIN_SALARY FROM EMPLOYEE WHERE SALARY > 7000 GROUP BY JOB, DNO;

-- k. Find the minimum salary of manager in various department
SELECT DNO, MIN(SALARY) AS MIN_MANAGER_SALARY FROM EMPLOYEE WHERE JOB = 'Manager' GROUP BY DNO;

-- l. List the name of clerk along with the name of department
SELECT EMPLOYEE.ENAME, DEPARTMENT.DNAME FROM EMPLOYEE JOIN DEPARTMENT ON EMPLOYEE.DNO = DEPARTMENT.DNO WHERE EMPLOYEE.JOB = 'Clerk';

-- m. List the employee name and their date of joining in format DD/MM/YY
SELECT CONCAT(ENAME, ' joined on ', DATE_FORMAT(DOJ, '%d/%m/%Y')) AS JOINING_DETAILS FROM EMPLOYEE;

-- n. Update the salary of employees by 20%
UPDATE EMPLOYEE SET SALARY = SALARY * 1.2;

-- o. Update the salary of employee by 10000 whose salary is less than 7000
UPDATE EMPLOYEE SET SALARY = SALARY + 10000 WHERE SALARY < 7000;

-- p. Update the designation as senior clerk if the salary = 10000
UPDATE EMPLOYEE SET JOB = 'Senior Clerk' WHERE SALARY = 10000;

-- q. Delete the details of employee who joined before 1998
DELETE FROM EMPLOYEE WHERE DOJ < '1998-01-01';

-- r. Delete the details of employee working sales whose designation is worker
DELETE FROM EMPLOYEE WHERE DNO = 10 AND JOB = 'Worker';