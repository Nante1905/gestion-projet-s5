package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Matiere;
import com.nante.app.service.LookService;
import com.nante.app.service.MatiereService;

@Controller
@RequestMapping("matieres")
public class MatiereController {
    @Autowired
    private LookService lookService;

    @Autowired
    private MatiereService matiereService;

    @GetMapping("/create")
    public String insererMatiereVue(Model model) {
        return "creation-matiere.html";
    }

    @GetMapping("/insert")
    public String insererMatiere(Model model, @RequestBody Matiere m) {
        this.matiereService.save(m);
        return "redirect:/matieres";
    }

    @GetMapping("/look")
    public String findMatieresByIdLook(Model model, @RequestBody int idLook) throws NotFoundException {
        List<Matiere> matieres = lookService.findMatieresOf(idLook);
        model.addAttribute("matieres", matieres);
        return "matieres.html";
    }
}
