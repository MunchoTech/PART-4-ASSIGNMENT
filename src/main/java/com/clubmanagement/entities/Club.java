package com.clubmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "club")
@Data
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Integer clubId;

    @Column(name = "club_name", nullable = false)
    private String clubName;

    @Column(name = "description")
    private String description;
}
