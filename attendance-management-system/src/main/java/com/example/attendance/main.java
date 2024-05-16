package com.example.attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.attendance.members.Faculty;
import com.example.attendance.members.Student;
import com.example.attendance.members.implementations.FacultyDAOImpl;
import com.example.attendance.members.implementations.StudentDAOImpl;
import com.example.attendance.members.interfaces.FacultyDAO;
import com.example.attendance.members.interfaces.StudentDAO;

public class main {
    public static void main(String[] args) {
         // Create instances of your test classes
         TestAttendance testAttendance = new TestAttendance();

         // Call the test methods
         testAttendance.testStudent();
         testAttendance.testFaculty();
         testAttendance.testMember();

         // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/attendancemanagementsystem";
        String username = "root";
        String password = "Vimaya123!";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create DAO instances
            StudentDAO studentDAO = new StudentDAOImpl(connection);
            FacultyDAO facultyDAO = new FacultyDAOImpl(connection);

            // Example: Adding a student
            Student student = new Student(1, "John Doe", "john@example.com", 0, 4, 1000.0);
            boolean success = studentDAO.addStudent(student);
            if (success) {
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Failed to add student.");
            }

            // Example: Adding a faculty member
            Faculty faculty = new Faculty(1, "Jane Smith", "jane@example.com", 0, "TEACHING", 50000.0);
            success = facultyDAO.addFaculty(faculty);
            if (success) {
                System.out.println("Faculty member added successfully.");
            } else {
                System.out.println("Failed to add faculty member.");
            }

            // Close connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
