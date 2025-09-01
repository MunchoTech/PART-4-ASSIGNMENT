package com.example.Part4Assignment.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public  String test(){
        return "Hello My name is Robert and i am a CS Student and i cant lie guys i LOVE JAVA LIKE CRAZY!!";
    }





}
