package com.clubmanagement.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "equipment_records")
@Data
public class EquipmentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    @Column(name = "quantity_used", nullable = false)
    private Integer quantityUsed;

    @Column(name = "returned")
    private Boolean returned;
}
