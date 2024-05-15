package com.example.attendance;
import java.util.Objects;

public class student extends member {
    private int gpa;
    private double accountBalance;
    private String role = "Student";

    public student(int id, String name, String email, int attendance, int gpa, double accountBalance) {
        super(id, name, email, attendance);
        this.gpa = gpa;
        this.accountBalance = accountBalance;
    }

    public int getGpa() {
        return this.gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getRole() {
        return role;
    }

    public student gpa(int gpa) {
        setGpa(gpa);
        return this;
    }

    public student accountBalance(double accountBalance) {
        setAccountBalance(accountBalance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof student)) {
            return false;
        }
        student student = (student) o;
        return gpa == student.gpa && accountBalance == student.accountBalance && role == student.role && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), super.getName(), super.getEmail(), gpa, accountBalance);
    }

    @Override
    public String toString() {
        return "{" +
            " gpa='" + getGpa() + "'" +
            ", accountBalance='" + getAccountBalance() + "'" +
            ", role=' " + getRole() + "'" + 
            super.toString();
    }
    
}
