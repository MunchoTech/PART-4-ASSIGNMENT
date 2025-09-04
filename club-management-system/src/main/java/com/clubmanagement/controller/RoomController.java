package com.clubmanagement.controller;



import com.clubmanagement.entities.Room;
import com.clubmanagement.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer id) {
        Optional<Room> room = roomService.getRoomById(id);
        return room.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Integer id, @RequestBody Room roomDetails) {
        Optional<Room> roomOptional = roomService.getRoomById(id);
        if (roomOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Room room = roomOptional.get();
        room.setRoomName(roomDetails.getRoomName());
        room.setAvailability(roomDetails.getAvailability());
        Room updatedRoom = roomService.saveRoom(room);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
