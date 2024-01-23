package com.nante.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nante.app.service.BeneficeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/test")
public class TestController {

    @PersistenceContext()
    private EntityManager em;

    @Autowired
    private BeneficeService beneficeService;

    @GetMapping("")
    public String index() {
        // List<Look> matieres = em.createQuery("select l from Look l join fetch ",
        // Look.class).getResultList();
        // List<String> a = matieres.get(0).getMatieres().stream().map(m ->
        // m.getNom()).toList();

        // return String.join(", ", a);

        this.beneficeService.getBeneficeParSac();
        return "test";
    }
}
