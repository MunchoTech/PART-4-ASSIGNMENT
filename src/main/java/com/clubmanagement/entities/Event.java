package com.clubmanagement.entities;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "event")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
}