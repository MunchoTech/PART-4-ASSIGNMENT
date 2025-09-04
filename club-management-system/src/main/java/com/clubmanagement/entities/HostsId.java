package com.clubmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class HostsId {
    @Column(name = "club_id")
    private Integer clubId;

    @Column(name = "event_id")
    private Integer eventId;
}
