package com.nante.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nante.app.model.views.Benefice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
@RequestMapping("gestion")
public class BeneficeController {

    @PersistenceContext
    private EntityManager em;

    @GetMapping("/benef")
    public String benefView(Model model, @RequestParam(required = false, defaultValue = "1") int min,
            @RequestParam(required = false, defaultValue = "1") int max) {
        model.addAttribute("benefices", Benefice.getBeneficeBetween(this.em, min, max));
        model.addAttribute("page", "benefice/benef");
        return "layout/index";
    }
}
