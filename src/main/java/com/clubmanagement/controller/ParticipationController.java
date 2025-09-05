package com.clubmanagement.controller;

import com.clubmanagement.entities.Participation;
import com.clubmanagement.entities.ParticipationId;
import com.clubmanagement.Services.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participations")
public class ParticipationController {
    @Autowired
    private ParticipationService participationService;

    @GetMapping
    public List<Participation> getAllParticipations() {
        return participationService.getAllParticipations();
    }

    @GetMapping("/{studentId}/{eventId}")
    public ResponseEntity<Participation> getParticipationById(@PathVariable Integer studentId, @PathVariable Integer eventId) {
        ParticipationId id = new ParticipationId();
        id.setStudentId(studentId);
        id.setEventId(eventId);
        Optional<Participation> participation = participationService.getParticipationById(id);
        return participation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Participation createParticipation(@RequestBody Participation participation) {
        return participationService.saveParticipation(participation);
    }

    @PutMapping("/{studentId}/{eventId}")
    public ResponseEntity<Participation> updateParticipation(@PathVariable Integer studentId, @PathVariable Integer eventId, @RequestBody Participation participationDetails) {
        ParticipationId id = new ParticipationId();
        id.setStudentId(studentId);
        id.setEventId(eventId);
        Optional<Participation> participationOptional = participationService.getParticipationById(id);
        if (participationOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Participation participation = participationOptional.get();
        participation.setStudent(participationDetails.getStudent());
        participation.setEvent(participationDetails.getEvent());
        Participation updatedParticipation = participationService.saveParticipation(participation);
        return ResponseEntity.ok(updatedParticipation);
    }

    @DeleteMapping("/{studentId}/{eventId}")
    public ResponseEntity<Void> deleteParticipation(@PathVariable Integer studentId, @PathVariable Integer eventId) {
        ParticipationId id = new ParticipationId();
        id.setStudentId(studentId);
        id.setEventId(eventId);
        participationService.deleteParticipation(id);
        return ResponseEntity.noContent().build();
    }
}