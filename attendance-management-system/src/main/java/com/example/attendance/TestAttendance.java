package com.example.attendance;

import org.junit.Test;

import com.example.attendance.members.Student;
import com.example.attendance.members.Faculty;
import com.example.attendance.members.member;

import static org.junit.Assert.*;

public class TestAttendance {

    @Test
    public void testStudent() {
        Student student1 = new Student(1, "John", "john@example.com", 10, 3, 1000.0);
        Student student2 = new Student(2, "Alice", "alice@example.com", 8, 4, 1500.0);

        // Test getters
        assertEquals(1, student1.getId());
        assertEquals("John", student1.getName());
        assertEquals("john@example.com", student1.getEmail());
        assertEquals(10, student1.getAttendance());
        assertEquals(3, student1.getGpa(), 0.01);
        assertEquals(1000.0, student1.getAccountBalance(), 0.01);
        assertEquals("Student", student1.getRole());

        // Test setters
        student1.setGpa(4);
        assertEquals(4, student1.getGpa(), 0.01);

        student1.setAccountBalance(1200.0);
        assertEquals(1200.0, student1.getAccountBalance(), 0.01);

        // Test toString
        String expectedToString = "{ gpa='4', accountBalance='1200.0', role='Student', id='1', name='John', email='john@example.com', attendance='10'}\n";
        assertEquals(expectedToString, student1.toString());

        // Test equals
        assertFalse(student1.equals(student2));
    }

    @Test
    public void testFaculty() {
        Faculty faculty1 = new Faculty(1, "Dr. Smith", "smith@example.com", 20, "TEACHING" , 5000.0);
        Faculty faculty2 = new Faculty(2, "Dr. Brown", "brown@example.com", 18, "ADMINISTRATION", 6000.0);

        // Test getters
        assertEquals(1, faculty1.getId());
        assertEquals("Dr. Smith", faculty1.getName());
        assertEquals("smith@example.com", faculty1.getEmail());
        assertEquals(20, faculty1.getAttendance());
        assertEquals("TEACHING", faculty1.getDepartment());
        assertEquals(5000.0, faculty1.getSalary(), 0.01);

        // Test setters
        faculty1.setDepartment("ADMINISTRATION");
        assertEquals("ADMINISTRATION", faculty1.getDepartment());

        faculty1.setSalary(5500.0);
        assertEquals(5500.0, faculty1.getSalary(), 0.01);

        // Test toString
        String expectedToString = "{ department='ADMINISTRATION', salary='5500.0', id='1', name='Dr. Smith', email='smith@example.com', attendance='20'}\n";
        assertEquals(expectedToString, faculty1.toString());

        // Test equals
        assertFalse(faculty1.equals(faculty2));
    }

    @Test
    public void testMember() {
        member member1 = new member(1, "John", "john@example.com", 10);
        member member2 = new member(2, "Alice", "alice@example.com", 8);

        // Test getters
        assertEquals(1, member1.getId());
        assertEquals("John", member1.getName());
        assertEquals("john@example.com", member1.getEmail());
        assertEquals(10, member1.getAttendance());

        // Test setters
        member2.setId(2);
        assertEquals(2, member2.getId());

        member2.setName("Alice");
        assertEquals("Alice", member2.getName());

        member2.setEmail("alice@example.com");
        assertEquals("alice@example.com", member2.getEmail());

        member2.setAttendance(8);
        assertEquals(8, member2.getAttendance());

        // Test toString
        String expectedToString = " id='2', name='Alice', email='alice@example.com', attendance='8'}\n";
        assertEquals(expectedToString, member2.toString());

        // Test equals
        assertFalse(member1.equals(member2));
    }
}
