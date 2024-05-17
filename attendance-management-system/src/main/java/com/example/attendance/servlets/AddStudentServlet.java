package com.example.attendance.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.attendance.members.Student;
import com.example.attendance.members.implementations.StudentDAOImpl;
import com.example.attendance.members.interfaces.StudentDAO;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the DAO object and establish a connection to the database
        String jdbcUrl = "jdbc:mysql://localhost:3306/attendancemanagementsystem";
        String username = "root";
        String password = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            studentDAO = new StudentDAOImpl(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int attendance = Integer.parseInt(request.getParameter("attendance"));
        int gpa = Integer.parseInt(request.getParameter("gpa"));
        double accountBalance = Double.parseDouble(request.getParameter("account_balance"));

        // Create Student object
        Student student = new Student(studentId, name, email, attendance, gpa, accountBalance);

        // Call addStudent method
        boolean success = studentDAO.addStudent(student);

        // Handle success/failure and redirect
        if (success) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
