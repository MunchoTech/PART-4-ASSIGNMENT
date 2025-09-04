package com.clubmanagement.entities.repository;



import com.clubmanagement.entities.Participation;
import com.clubmanagement.entities.ParticipationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, ParticipationId> {
}
