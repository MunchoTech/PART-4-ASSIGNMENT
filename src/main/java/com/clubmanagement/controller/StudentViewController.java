package com.clubmanagement.controller;

import com.clubmanagement.entities.Student;
import com.clubmanagement.entities.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentViewController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }
}