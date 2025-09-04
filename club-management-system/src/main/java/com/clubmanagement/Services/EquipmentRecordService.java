package com.clubmanagement.Services;



import com.clubmanagement.entities.EquipmentRecord;
import com.clubmanagement.entities.repository.EquipmentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentRecordService {
    @Autowired
    private EquipmentRecordRepository equipmentRecordRepository;

    public List<EquipmentRecord> getAllEquipmentRecords() {
        return equipmentRecordRepository.findAll();
    }

    public Optional<EquipmentRecord> getEquipmentRecordById(Integer id) {
        return equipmentRecordRepository.findById(id);
    }

    public EquipmentRecord saveEquipmentRecord(EquipmentRecord equipmentRecord) {
        return equipmentRecordRepository.save(equipmentRecord);
    }

    public void deleteEquipmentRecord(Integer id) {
        equipmentRecordRepository.deleteById(id);
    }
}
