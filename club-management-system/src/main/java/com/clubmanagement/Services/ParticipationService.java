package com.clubmanagement.Services;



import com.clubmanagement.entities.Participation;
import com.clubmanagement.entities.ParticipationId;
import com.clubmanagement.entities.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService {
    @Autowired
    private ParticipationRepository participationRepository;

    public List<Participation> getAllParticipations() {
        return participationRepository.findAll();
    }

    public Optional<Participation> getParticipationById(ParticipationId id) {
        return participationRepository.findById(id);
    }

    public Participation saveParticipation(Participation participation) {
        return participationRepository.save(participation);
    }

    public void deleteParticipation(ParticipationId id) {
        participationRepository.deleteById(id);
    }
}