package com.nante.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("clients")
public class ClientController {

    @GetMapping("/ajout")
    public String ajoutClient(Model model) {
        model.addAttribute("page", "ajout-client");
        return "layout/index";
    }
    
}
