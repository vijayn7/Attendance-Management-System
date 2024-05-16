<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Student</title>
    <style>
        /* Add your CSS styles here */
    </style>
</head>
<body>
    <h1>Add New Student</h1>
    <form action="addStudent" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="attendance">Attendance:</label>
        <input type="number" id="attendance" name="attendance" required><br><br>
        
        <label for="gpa">GPA:</label>
        <input type="number" id="gpa" name="gpa" step="0.01" required><br><br>
        
        <label for="accountBalance">Account Balance:</label>
        <input type="number" id="accountBalance" name="accountBalance" step="0.01" required><br><br>
        
        <input type="submit" value="Add Student">
    </form>
</body>
</html>