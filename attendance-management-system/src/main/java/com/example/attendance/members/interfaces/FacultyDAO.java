package com.example.attendance.members.interfaces;

import java.util.List;
import com.example.attendance.members.Faculty;

public interface FacultyDAO {
    boolean addFaculty(Faculty faculty);
    boolean updateFaculty(Faculty faculty);
    boolean deleteFaculty(int facultyId);
    Faculty getFacultyById(int facultyId);
    List<Faculty> getAllFaculty();
}
