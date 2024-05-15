package com.example.attendance.members;
import java.util.Objects;

public class Member {
    private int id;
    private String name;
    private String email;
    private int attendance;

    public Member(int id, String name, String email, int attendance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.attendance = attendance;
    }

    public int getAttendance() {
        return this.attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
    public void incrementAttendance() {
        attendance++;
    }

    public Member attendance(int attendance) {
        setAttendance(attendance);
        return this;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Member id(int id) {
        setId(id);
        return this;
    }

    public Member name(String name) {
        setName(name);
        return this;
    }

    public Member email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Member)) {
            return false;
        }
        Member member = (Member) o;
        return id == member.id && Objects.equals(name, member.name) && Objects.equals(email, member.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", attendance='" + getAttendance() + "'}\n";
    }
    
}
