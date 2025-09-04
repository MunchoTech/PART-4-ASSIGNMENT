package com.clubmanagement.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hosts")
@Data
public class Hosts {
    @EmbeddedId
    private HostsId id;

    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;
}

