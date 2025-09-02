package com.example.clubmanagement.controller;

import com.example.clubmanagement.entity.Event;
import com.example.clubmanagement.entity.Participation;
import com.example.clubmanagement.entity.ParticipationId;
import com.example.clubmanagement.entity.Student;
import com.example.clubmanagement.repository.EventRepository;
import com.example.clubmanagement.repository.ParticipationRepository;
import com.example.clubmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private ParticipationRepository participationRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EventRepository eventRepository; // Add the new repository

    @GetMapping("/reports/event/{id}")
    public String showEventParticipants(@PathVariable("id") int eventId, Model model) {
        List<Participation> participants = participationRepository.findParticipantsByEventId(eventId);
        model.addAttribute("participants", participants);

        // This will now work without errors!
        if (!participants.isEmpty()) {
            model.addAttribute("eventName", participants.get(0).getEvent().getEventName());
        } else {
            // If no participants, we need to find the event name a different way
            eventRepository.findById(eventId)
                .ifPresent(event -> model.addAttribute("eventName", event.getEventName()));
        }
        return "reports";
    }

    @PostMapping("/events/{eventId}/register")
    public String registerForEvent(@PathVariable("eventId") int eventId, RedirectAttributes redirectAttributes) {
        int currentStudentId = 2021; // Example student ID

        // Fetch the full Student and Event objects from the database
        Student student = studentRepository.findById(currentStudentId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (student != null && event != null) {
            // Create a new Participation record
            Participation newParticipation = new Participation();
            newParticipation.setId(new ParticipationId(currentStudentId, eventId));
            newParticipation.setStudent(student);
            newParticipation.setEvent(event);

            participationRepository.save(newParticipation);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully registered!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Registration failed: Student or Event not found.");
        }
        return "redirect:/reports/event/" + eventId;
    }
}