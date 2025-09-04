package com.clubmanagement.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "equipment")
@Data
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Integer equipmentId;

    @Column(name = "equipment_name", nullable = false)
    private String equipmentName;

    @Column(name = "total_equipment", nullable = false)
    private Integer totalEquipment;
}