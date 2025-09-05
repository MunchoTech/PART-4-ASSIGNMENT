package com.clubmanagement.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_firstName", nullable = false)
    private String studentFirstName;

    @Column(name = "student_lastName", nullable = false)
    private String studentLastName;

    @Column(name = "program_name", nullable = false)
    private String programName;

    @Column(name = "year", nullable = false)
    private Integer year;
}