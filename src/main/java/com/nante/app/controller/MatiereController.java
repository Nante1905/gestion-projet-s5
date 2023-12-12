package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nante.app.model.Look;
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

    @PostMapping("/insert")
    public String insererMatiere(Model model, @ModelAttribute Matiere m) {
        this.matiereService.save(m);
        return "redirect:/matieres";
    }

    @GetMapping("/look")
    public String findMatieresByIdLook(Model model, @RequestParam(defaultValue = "1") String idLook)
            throws NotFoundException {
        try {
            List<Look> looks = lookService.findAll();
            List<Matiere> matieres = lookService.findMatieresOf(Integer.parseInt(idLook));
            model.addAttribute("matieres", matieres);
            model.addAttribute("looks", looks);
            return "matieres.html";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
