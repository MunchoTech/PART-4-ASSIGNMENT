package com.clubmanagement.Services;

import com.clubmanagement.entities.Equipment;
import com.clubmanagement.entities.repository.EquipmentRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRecord equipmentRepository;

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> getEquipmentById(Integer id) {
        return equipmentRepository.findById(id);
    }

    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Integer id) {
        equipmentRepository.deleteById(id);
    }
}
