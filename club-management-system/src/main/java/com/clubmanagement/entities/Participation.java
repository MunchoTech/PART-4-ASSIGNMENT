package com.clubmanagement.entities;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "participation")
@Data
public class Participation {
    @EmbeddedId
    private ParticipationId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;
}

