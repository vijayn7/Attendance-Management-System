package com.example.attendance;
import java.util.Objects;

public class faculty extends member{
    public enum departments {TEACHING, ADMINISTRATION, ATHLETICS, OTHER}
    private departments department;
    private double salary;

    public faculty(int id, String name, String email, int attendance, departments department, double salary) {
        super(id, name, email, attendance);
        this.department = department;
        this.salary = salary;
    }

    public departments getDepartment() {
        return this.department;
    }

    public void setDepartment(departments department) {
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public faculty department(departments department) {
        setDepartment(department);
        return this;
    }

    public faculty salary(double salary) {
        setSalary(salary);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof faculty)) {
            return false;
        }
        faculty faculty = (faculty) o;
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
            ", salary='" + getSalary() + "'" +
            super.toString();
    }
}
