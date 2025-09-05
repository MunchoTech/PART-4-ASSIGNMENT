package com.clubmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ParticipationId {
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "event_id")
    private Integer eventId;
}

