show databases;
use attendancemanagementsystem;

-- Create students table
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    attendance INT,
    gpa INT,
    account_balance double
    -- Add more columns as needed
);

-- Create faculty table
CREATE TABLE faculty (
    faculty_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    attendance INT,
    department VARCHAR(100),
    salary double
    -- Add more columns as needed
);

-- Create attendance records table
CREATE TABLE attendance_records (
    record_id INT PRIMARY KEY,
    student_id INT,
    faculty_id INT,
    date DATE,
    status VARCHAR(10),
    -- Add more columns as needed
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)
);