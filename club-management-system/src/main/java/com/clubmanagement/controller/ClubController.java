package com.clubmanagement.controller;



import com.clubmanagement.entities.Club;
import com.clubmanagement.Services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable Integer id) {
        Optional<Club> club = clubService.getClubById(id);
        return club.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Club createClub(@RequestBody Club club) {
        return clubService.saveClub(club);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable Integer id, @RequestBody Club clubDetails) {
        Optional<Club> clubOptional = clubService.getClubById(id);
        if (clubOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Club club = clubOptional.get();
        club.setClubName(clubDetails.getClubName());
        club.setDescription(clubDetails.getDescription());
        Club updatedClub = clubService.saveClub(club);
        return ResponseEntity.ok(updatedClub);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Integer id) {
        clubService.deleteClub(id);
        return ResponseEntity.noContent().build();
    }
}
