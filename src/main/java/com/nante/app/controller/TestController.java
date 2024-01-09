package com.nante.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nante.app.model.Look;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/test")
public class TestController {

    @PersistenceContext()
    private EntityManager em;

    @GetMapping("")
    public String index() {
        List<Look> matieres = em.createQuery("select l from Look l join fetch ", Look.class).getResultList();
        List<String> a = matieres.get(0).getMatieres().stream().map(m -> m.getNom()).toList();

        return String.join(", ", a);
    }
}
