package com.clubmanagement.entities;


import com.clubmanagement.entities.Club;
import com.clubmanagement.entities.RegistrationId;
import com.clubmanagement.entities.Student;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "registration")
@Data
public class Registration {
    @EmbeddedId
    private RegistrationId id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private Club club;
}

