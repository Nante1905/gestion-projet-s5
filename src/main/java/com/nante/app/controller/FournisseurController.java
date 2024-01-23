package com.nante.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Fournisseur;
import com.nante.app.repository.FournisseurRepository;

@Controller
@RequestMapping("fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping("create")
    public String ajoutFournisseurView(Model model) {

        model.addAttribute("page", "fournisseurs/ajout-fournisseur");

        return "layout/index";
    }

    @PostMapping("insert")
    public String ajoutFournisseur(Model model, @ModelAttribute Fournisseur fournisseur) {

        fournisseurRepository.save(fournisseur);

        return "redirect:/fournisseurs/ajout-fournisseur.html";
    }
}
