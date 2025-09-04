package com.clubmanagement.controller;


import com.clubmanagement.entities.Registration;
import com.clubmanagement.entities.RegistrationId;
import com.clubmanagement.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{studentId}/{clubId}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Integer studentId, @PathVariable Integer clubId) {
        RegistrationId id = new RegistrationId();
        id.setStudentId(studentId);
        id.setClubId(clubId);
        Optional<Registration> registration = registrationService.getRegistrationById(id);
        return registration.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationService.saveRegistration(registration);
    }

    @PutMapping("/{studentId}/{clubId}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable Integer studentId, @PathVariable Integer clubId, @RequestBody Registration registrationDetails) {
        RegistrationId id = new RegistrationId();
        id.setStudentId(studentId);
        id.setClubId(clubId);
        Optional<Registration> registrationOptional = registrationService.getRegistrationById(id);
        if (registrationOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Registration registration = registrationOptional.get();
        registration.setDate(registrationDetails.getDate());
        registration.setStudent(registrationDetails.getStudent());
        registration.setClub(registrationDetails.getClub());
        Registration updatedRegistration = registrationService.saveRegistration(registration);
        return ResponseEntity.ok(updatedRegistration);
    }

    @DeleteMapping("/{studentId}/{clubId}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Integer studentId, @PathVariable Integer clubId) {
        RegistrationId id = new RegistrationId();
        id.setStudentId(studentId);
        id.setClubId(clubId);
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }
}
