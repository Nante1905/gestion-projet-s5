package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Look;
import com.nante.app.model.Taille;
import com.nante.app.model.Type;
import com.nante.app.service.LookService;
import com.nante.app.service.TailleService;
import com.nante.app.service.TypeService;

@Controller
@RequestMapping("gestion")
public class GestionController {

    @Autowired
    LookService lookService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TailleService tailleService;

    @GetMapping("/edit-emp-min")
    public String editEmpMin(Model model) {
        return "edit-emp-min.html";
    }

    @GetMapping("/edit-taux-horaire")
    public String editTauxHoraire(Model model) {
        return "edit-taux-horaire.html";
    }

    @GetMapping("/edit-duree-travail")
    public String editDureeTravail(Model model) {
        List<Look> looks = lookService.findAll();
        model.addAttribute("looks", looks);
        return "edit-duree-travail.html";
    }

    @GetMapping("/ajout-prix-vente")
    public String ajoutPrixVente(Model model) {
        List<Type> types = typeService.findAll();
        List<Taille> tailles = tailleService.findAll();
        List<Look> looks = lookService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("tailles", tailles);
        model.addAttribute("looks", looks);
        return "ajout-prix-vente.html";
    }
}
