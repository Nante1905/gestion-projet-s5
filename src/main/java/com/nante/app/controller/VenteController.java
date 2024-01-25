package com.nante.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Client;
import com.nante.app.model.Sac;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
@RequestMapping("ventes")
public class VenteController {

    @PersistenceContext()
    private EntityManager em;
    
    @GetMapping("/ajout")
    public String ajoutVente(Model model) {
        List<Sac> liste_sac = this.em.createNativeQuery("select * from sac", Sac.class).getResultList();
        List<Client> liste_client = this.em.createNativeQuery("select * from client", Client.class).getResultList();
        model.addAttribute("sacs", liste_sac);
        model.addAttribute("clients" , liste_client);
        model.addAttribute("page","vente");
        return "layout/index";
    }

}
