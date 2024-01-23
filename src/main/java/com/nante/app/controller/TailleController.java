package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Taille;
import com.nante.app.service.TailleService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("taille")
public class TailleController {

    @Autowired
    private EntityManager em;

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

    @GetMapping("/ajout-ordre")
    public String ajoutOrdreTailleView(Model model) {
        List<Taille> tailles = tailleService.findAll();
        model.addAttribute("tailles", tailles);
        return "benefice/taille-ajout-ordre.html";
    }

    @PostMapping("/ajout-ordre")
    @Transactional
    public String ajoutOrderTaille(Model model, @ModelAttribute Taille taille) {
        this.em.createNativeQuery(
                "update taille set ordre = " + taille.getOrdre() + " where id = " + taille.getId() + "")
                .executeUpdate();
        return "redirect:/taille/ajout-ordre";
    }

}
