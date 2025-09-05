package com.clubmanagement.controller;



import com.clubmanagement.entities.Equipment;
import com.clubmanagement.Services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Integer id) {
        Optional<Equipment> equipment = equipmentService.getEquipmentById(id);
        return equipment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return equipmentService.saveEquipment(equipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Integer id, @RequestBody Equipment equipmentDetails) {
        Optional<Equipment> equipmentOptional = equipmentService.getEquipmentById(id);
        if (equipmentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Equipment equipment = equipmentOptional.get();
        equipment.setEquipmentName(equipmentDetails.getEquipmentName());
        equipment.setTotalEquipment(equipmentDetails.getTotalEquipment());
        Equipment updatedEquipment = equipmentService.saveEquipment(equipment);
        return ResponseEntity.ok(updatedEquipment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer id) {
        equipmentService.deleteEquipment(id);
        return ResponseEntity.noContent().build();
    }
}
