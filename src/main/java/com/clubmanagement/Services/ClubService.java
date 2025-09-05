package com.clubmanagement.Services;



import com.clubmanagement.entities.Club;
import com.clubmanagement.entities.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Optional<Club> getClubById(Integer id) {
        return clubRepository.findById(id);
    }

    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    public void deleteClub(Integer id) {
        clubRepository.deleteById(id);
    }
}