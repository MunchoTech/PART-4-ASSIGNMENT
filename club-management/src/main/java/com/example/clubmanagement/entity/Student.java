package com.example.clubmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id") // Maps to the 'student_id' column
    private int id;

    // This annotation is the critical fix.
    // It tells JPA that the 'firstName' field maps to the 'student_firstName' column.
    @Column(name = "student_firstName")
    private String firstName;

    // This annotation is also a critical fix.
    // It tells JPA that the 'lastName' field maps to the 'student_lastName' column.
    @Column(name = "student_lastName")
    private String lastName;
    
    @Column(name = "program_name")
    private String programName;

    @Column(name = "year")
    private int year;

    // --- GETTERS AND SETTERS ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}