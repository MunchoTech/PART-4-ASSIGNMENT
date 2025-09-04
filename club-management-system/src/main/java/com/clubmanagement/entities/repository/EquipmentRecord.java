package com.clubmanagement.entities.repository;

import com.clubmanagement.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRecord extends JpaRepository<Equipment, Integer> {
}