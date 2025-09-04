
package com.StudentclubManagement.Clubmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.StudentclubManagement.Clubmanagement.Model.Events;
import com.StudentclubManagement.Clubmanagement.Repository.ClubRepository;
import com.StudentclubManagement.Clubmanagement.Repository.EventRepository;

// EventController.java
@Controller
@RequestMapping("/Events")
public class EventController {
    private final EventRepository eventRepo;
    private final ClubRepository clubRepo;

    public EventController(EventRepository eventRepo, ClubRepository clubRepo) {
        this.eventRepo = eventRepo;
        this.clubRepo = clubRepo;
    }

    @GetMapping("")
    public String listEvents(Model model) {
        model.addAttribute("Events", eventRepo.findAll());
        return "Event";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("Event", new Events());
        model.addAttribute("Clubs", clubRepo.findAll());
        return "Add_Event";
    }

    @PostMapping
    public String saveEvent(@ModelAttribute Events event) {
        eventRepo.save(event);
        return "redirect:/Events";
    }
}