package com.clubmanagement.entities.repository;

import com.clubmanagement.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Integer> {
}