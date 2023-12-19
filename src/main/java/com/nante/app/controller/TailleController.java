package com.nante.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Taille;
import com.nante.app.service.TailleService;

@Controller
@RequestMapping("taille")
public class TailleController {

    @Autowired
    TailleService tailleService;

    @GetMapping("/create")
    public String create(Model model) {
        return "creation-taille";
    }

    @PostMapping("/insert")
    public String insert(Model model, @ModelAttribute Taille taille) {
        this.tailleService.save(taille);
        return "redirect:/taille/create";
    }
}
