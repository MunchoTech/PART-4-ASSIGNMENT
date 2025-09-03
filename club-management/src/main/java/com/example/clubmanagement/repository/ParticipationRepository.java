package com.example.clubmanagement.repository;

import com.example.clubmanagement.entity.Participation;
import com.example.clubmanagement.entity.ParticipationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, ParticipationId> {

    @Query("SELECT p FROM Participation p JOIN FETCH p.student s JOIN FETCH p.event e WHERE e.id = :eventId")
    List<Participation> findParticipantsByEventId(@Param("eventId") int eventId);
}