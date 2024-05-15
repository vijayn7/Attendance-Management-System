package com.example.attendance.members;
import java.util.Objects;

public class Faculty extends Member{
    private String department;
    private double salary;

    public Faculty(int id, String name, String email, int attendance, String department, double salary) {
        super(id, name, email, attendance);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Faculty department(String department) {
        setDepartment(department);
        return this;
    }

    public Faculty salary(double salary) {
        setSalary(salary);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Faculty)) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        return Objects.equals(department, faculty.department) && salary == faculty.salary && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, salary);
    }

    @Override
    public String toString() {
        return "{" +
            " department='" + getDepartment() + "'" +
            ", salary='" + getSalary() + "'," +
            super.toString();
    }
}
