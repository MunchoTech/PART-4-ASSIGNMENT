package com.clubmanagement.controller;



import com.clubmanagement.entities.EquipmentRecord;
import com.clubmanagement.Services.EquipmentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipment-records")
public class EquipmentRecordController {
    @Autowired
    private EquipmentRecordService equipmentRecordService;

    @GetMapping
    public List<EquipmentRecord> getAllEquipmentRecords() {
        return equipmentRecordService.getAllEquipmentRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentRecord> getEquipmentRecordById(@PathVariable Integer id) {
        Optional<EquipmentRecord> equipmentRecord = equipmentRecordService.getEquipmentRecordById(id);
        return equipmentRecord.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EquipmentRecord createEquipmentRecord(@RequestBody EquipmentRecord equipmentRecord) {
        return equipmentRecordService.saveEquipmentRecord(equipmentRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentRecord> updateEquipmentRecord(@PathVariable Integer id, @RequestBody EquipmentRecord equipmentRecordDetails) {
        Optional<EquipmentRecord> equipmentRecordOptional = equipmentRecordService.getEquipmentRecordById(id);
        if (equipmentRecordOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        EquipmentRecord equipmentRecord = equipmentRecordOptional.get();
        equipmentRecord.setEvent(equipmentRecordDetails.getEvent());
        equipmentRecord.setEquipment(equipmentRecordDetails.getEquipment());
        equipmentRecord.setQuantityUsed(equipmentRecordDetails.getQuantityUsed());
        equipmentRecord.setReturned(equipmentRecordDetails.getReturned());
        EquipmentRecord updatedEquipmentRecord = equipmentRecordService.saveEquipmentRecord(equipmentRecord);
        return ResponseEntity.ok(updatedEquipmentRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipmentRecord(@PathVariable Integer id) {
        equipmentRecordService.deleteEquipmentRecord(id);
        return ResponseEntity.noContent().build();
    }
}