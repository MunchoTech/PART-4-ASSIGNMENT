package com.clubmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class RegistrationId {
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "club_id")
    private Integer clubId;
}