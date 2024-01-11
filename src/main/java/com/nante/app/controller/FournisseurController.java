package com.nante.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("create")
    public String ajoutFournisseurView(Model model) {

        return "fournisseurs/ajout-fournisseur.html";
    }

    @PostMapping("create")
    public String ajoutFournisseur(Model model, @ModelAttribute Fournisseur fournisseur) {

        fournisseurRepository.save(fournisseur);

        return "redirect:fournisseurs/ajout-fournisseur.html";
    }
}
