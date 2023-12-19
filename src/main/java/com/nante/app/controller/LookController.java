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
@RequestMapping("looks")
public class LookController {

    @Autowired
    MatiereService matiereService;

    @Autowired
    LookService lookService;

    @GetMapping("create")
    public String create(Model model) {
        return "look/creation-look.html";
    }

    @GetMapping("add-matiere")
    public String addMatiereToLookView(Model model) {
        List<Matiere> matieres = matiereService.findAll();
        model.addAttribute("matieres", matieres);
        List<Look> looks = lookService.findAll();
        model.addAttribute("looks", looks);

        return "look/ajout-matiere-look.html";
    }

    @PostMapping("add-matiere")
    public String addMatiereToLook(Model model, @RequestParam int look,
            @RequestParam(name = "matieres[]", defaultValue = "") List<String> matieres)
            throws NotFoundException {

        Look l = lookService.find(look);
        for (String matiere : matieres) {
            int idMatiere = Integer.parseInt(matiere);
            l.addMatiere(new Matiere(idMatiere));
        }

        lookService.save(l);

        return "redirect:/looks/add-matiere";
    }

    @PostMapping("insert")
    public String insert(@ModelAttribute Look look) {
        lookService.save(look);
        return "redirect:/matieres/look";
    }

}
