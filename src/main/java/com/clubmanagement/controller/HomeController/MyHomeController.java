package com.clubmanagement.controller.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyHomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
