package com.clubmanagement.controller;

import com.clubmanagement.entities.Event;
import com.clubmanagement.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Integer id, @RequestBody Event eventDetails) {
        Optional<Event> eventOptional = eventService.getEventById(id);
        if (eventOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Event event = eventOptional.get();
        event.setEventName(eventDetails.getEventName());
        event.setEventDate(eventDetails.getEventDate());
        event.setRoom(eventDetails.getRoom());
        Event updatedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}