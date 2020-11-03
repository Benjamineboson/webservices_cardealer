package com.example.webservices_cardealer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @GetMapping
    public String welcomeAsHTML() {
        return "index";
    }
}
