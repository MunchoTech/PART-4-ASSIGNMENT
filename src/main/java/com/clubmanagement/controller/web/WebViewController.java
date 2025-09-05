package com.clubmanagement.controller.web;

import com.clubmanagement.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/web")
public class WebViewController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String API_BASE_URL = "http://localhost:8080/api";

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("students", restTemplate.getForObject(API_BASE_URL + "/students", Student[].class));
        model.addAttribute("clubs", restTemplate.getForObject(API_BASE_URL + "/clubs", Club[].class));
        model.addAttribute("events", restTemplate.getForObject(API_BASE_URL + "/events", Event[].class));
        model.addAttribute("rooms", restTemplate.getForObject(API_BASE_URL + "/rooms", Room[].class));
        return "dashboard";
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", restTemplate.getForObject(API_BASE_URL + "/students", Student[].class));
        return "students";
    }

    @GetMapping("/clubs")
    public String clubs(Model model) {
        model.addAttribute("clubs", restTemplate.getForObject(API_BASE_URL + "/clubs", Club[].class));
        return "clubs";
    }

    @GetMapping("/events")
    public String events(Model model) {
        model.addAttribute("events", restTemplate.getForObject(API_BASE_URL + "/events", Event[].class));
        model.addAttribute("rooms", restTemplate.getForObject(API_BASE_URL + "/rooms", Room[].class));
        return "events";
    }

    @GetMapping("/equipment")
    public String equipment(Model model) {
        model.addAttribute("equipment", restTemplate.getForObject(API_BASE_URL + "/equipment", Equipment[].class));
        return "equipment";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", restTemplate.getForObject(API_BASE_URL + "/rooms", Room[].class));
        return "rooms";
    }

    @GetMapping("/registrations")
    public String registrations(Model model) {
        model.addAttribute("registrations", restTemplate.getForObject(API_BASE_URL + "/registrations", Registration[].class));
        model.addAttribute("students", restTemplate.getForObject(API_BASE_URL + "/students", Student[].class));
        model.addAttribute("clubs", restTemplate.getForObject(API_BASE_URL + "/clubs", Club[].class));
        return "registrations";
    }

    @GetMapping("/participations")
    public String participations(Model model) {
        model.addAttribute("participations", restTemplate.getForObject(API_BASE_URL + "/participations", Participation[].class));
        model.addAttribute("students", restTemplate.getForObject(API_BASE_URL + "/students", Student[].class));
        model.addAttribute("events", restTemplate.getForObject(API_BASE_URL + "/events", Event[].class));
        return "participations";
    }

    @GetMapping("/equipment-records")
    public String equipmentRecords(Model model) {
        model.addAttribute("equipmentRecords", restTemplate.getForObject(API_BASE_URL + "/equipment-records", EquipmentRecord[].class));
        model.addAttribute("students", restTemplate.getForObject(API_BASE_URL + "/students", Student[].class));
        model.addAttribute("equipment", restTemplate.getForObject(API_BASE_URL + "/equipment", Equipment[].class));
        model.addAttribute("clubs", restTemplate.getForObject(API_BASE_URL + "/clubs", Club[].class));
        return "equipment-records";
    }
}