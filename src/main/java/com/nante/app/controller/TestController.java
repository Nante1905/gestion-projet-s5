package com.nante.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.service.BeneficeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
@RequestMapping("/test")
public class TestController {

    @PersistenceContext()
    private EntityManager em;

    @Autowired
    private BeneficeService beneficeService;

    @GetMapping("")
    public String index(Model m) {
        // List<Look> matieres = em.createQuery("select l from Look l join fetch ",
        // Look.class).getResultList();
        // List<String> a = matieres.get(0).getMatieres().stream().map(m ->
        // m.getNom()).toList();

        // return String.join(", ", a);

        // this.beneficeService.getBeneficeParSac();
        // m.addAttribute("styles", new String[] { "haha", "huhu", "lolo" });
        // m.addAttribute("page", "layout/test");
        return "layout/index.html";
    }
}
