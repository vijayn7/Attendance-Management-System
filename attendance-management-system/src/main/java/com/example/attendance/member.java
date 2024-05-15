package com.example.attendance;
import java.util.Objects;

public class member {
    private int id;
    private String name;
    private String email;
    private int attendance;

    public member(int id, String name, String email, int attendance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.attendance = attendance;
    }

    public member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        attendance = 0;
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

    public member attendance(int attendance) {
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

    public member id(int id) {
        setId(id);
        return this;
    }

    public member name(String name) {
        setName(name);
        return this;
    }

    public member email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof member)) {
            return false;
        }
        member member = (member) o;
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
            ", attendance='" + getAttendance() + "\n";
    }
    
}
