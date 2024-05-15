package com.example.attendance.members.interfaces;

import java.util.List;
import com.example.attendance.members.Student;

public interface StudentDAO {
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int studentId);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();
}