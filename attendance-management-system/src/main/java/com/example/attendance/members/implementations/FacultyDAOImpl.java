package com.example.attendance.members.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.attendance.members.Faculty;
import com.example.attendance.members.interfaces.FacultyDAO;

public class FacultyDAOImpl implements FacultyDAO {
    private Connection connection;

    public FacultyDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addFaculty(Faculty faculty) {
        String sql = "INSERT INTO faculty (faculty_id, name, email, attendance, department, salary) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, faculty.getId());
            preparedStatement.setString(2, faculty.getName());
            preparedStatement.setString(3, faculty.getEmail());
            preparedStatement.setInt(4, faculty.getAttendance());
            preparedStatement.setString(5, faculty.getDepartment());
            preparedStatement.setDouble(6, faculty.getSalary());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateFaculty(Faculty faculty) {
        String sql = "UPDATE faculty SET name=?, email=?, attendance=?, department=?, salary=? WHERE faculty_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, faculty.getName());
            preparedStatement.setString(2, faculty.getEmail());
            preparedStatement.setInt(3, faculty.getAttendance());
            preparedStatement.setString(4, faculty.getDepartment());
            preparedStatement.setDouble(5, faculty.getSalary());
            preparedStatement.setInt(6, faculty.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFaculty(int facultyId) {
        String sql = "DELETE FROM faculty WHERE faculty_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, facultyId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Faculty getFacultyById(int facultyId) {
        String sql = "SELECT * FROM faculty WHERE faculty_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, facultyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Faculty(
                        resultSet.getInt("faculty_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("attendance"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Faculty> getAllFaculty() {
        List<Faculty> facultyList = new ArrayList<>();
        String sql = "SELECT * FROM faculty";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                facultyList.add(new Faculty(
                        resultSet.getInt("faculty_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("attendance"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facultyList;
    }
}
