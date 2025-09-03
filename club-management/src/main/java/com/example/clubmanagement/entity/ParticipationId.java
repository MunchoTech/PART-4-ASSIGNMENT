package com.example.clubmanagement.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable // Mark this class as embeddable
public class ParticipationId implements Serializable {

    private int studentId;
    private int eventId;

    // JPA requires a no-argument constructor
    public ParticipationId() {}

     // --- CONSTRUCTOR ---
    public ParticipationId(int studentId, int eventId) {
        this.studentId = studentId;
        this.eventId = eventId;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    // JPA requires equals() and hashCode() for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipationId that = (ParticipationId) o;
        return studentId == that.studentId && eventId == that.eventId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, eventId);
    }
}