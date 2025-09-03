package com.example.clubmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "participation")
public class Participation {

    @EmbeddedId // Use the @EmbeddedId strategy for the composite key
    private ParticipationId id;

    @ManyToOne
    @MapsId("studentId") // Maps the 'studentId' part of the composite key
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("eventId") // Maps the 'eventId' part of the composite key
    @JoinColumn(name = "event_id")
    private Event event;

    // Getters and Setters
    public ParticipationId getId() {
        return id;
    }

    public void setId(ParticipationId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}