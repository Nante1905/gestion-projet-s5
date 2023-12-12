package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Look;
import com.nante.app.model.Matiere;
import com.nante.app.service.LookService;
import com.nante.app.service.MatiereService;

@Controller
@RequestMapping("looks")
public class LookController {

    @Autowired
    MatiereService matiereService;

    @Autowired
    LookService lookService;

    @GetMapping("create")
    public String create(Model model) {
        List<Matiere> matieres = matiereService.findAll();
        model.addAttribute("matieres", matieres);
        return "creation-look.html";
    }

    @PostMapping("insert")
    public String insert(@ModelAttribute Look look) {
        lookService.save(look);
        return "redirect:/matieres/look";
    }
}
