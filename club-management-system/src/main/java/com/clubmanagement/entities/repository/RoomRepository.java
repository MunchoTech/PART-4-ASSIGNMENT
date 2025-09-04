package com.clubmanagement.entities.repository;

import com.clubmanagement.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}