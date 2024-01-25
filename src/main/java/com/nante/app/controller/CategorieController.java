package com.nante.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.CategorieEmp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("categorie")
public class CategorieController {

    @PersistenceContext
    private EntityManager em;

    @GetMapping("ajout")
    public String addCategorieForm(Model model) {
        model.addAttribute("page", "emp/ajout-categorie-form");
        return "layout/index";
    }

    @PostMapping("insert")
    @Transactional
    public String addCategorie(@ModelAttribute CategorieEmp categorieEmp) throws Exception {

        categorieEmp.insert(this.em);
        return "redirect:/categorie/ajout";

    }
}
