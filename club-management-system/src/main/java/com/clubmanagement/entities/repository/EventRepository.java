package com.clubmanagement.entities.repository;



import com.clubmanagement.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
