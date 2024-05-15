package com.example.attendance.members.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.attendance.members.Student;
import com.example.attendance.members.interfaces.StudentDAO;

public class StudentDAOImpl implements StudentDAO {
    private Connection connection;

    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (student_id, name, email, attendance, gpa, account_balance) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getAttendance());
            preparedStatement.setInt(5, student.getGpa());
            preparedStatement.setDouble(6, student.getAccountBalance());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, email=?, attendance=?, gpa=?, account_balance=? WHERE student_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAttendance());
            preparedStatement.setInt(4, student.getGpa());
            preparedStatement.setDouble(5, student.getAccountBalance());
            preparedStatement.setInt(6, student.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        String sql = "SELECT * FROM students WHERE student_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("attendance"),
                        resultSet.getInt("gpa"),
                        resultSet.getDouble("account_balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("attendance"),
                        resultSet.getInt("gpa"),
                        resultSet.getDouble("account_balance")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
