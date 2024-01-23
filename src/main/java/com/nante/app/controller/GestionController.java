package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Look;
import com.nante.app.model.NbrMinEmp;
import com.nante.app.model.PrixVente;
import com.nante.app.model.Taille;
import com.nante.app.model.TauxHoraire;
import com.nante.app.model.TempsFabrication;
import com.nante.app.model.Type;
import com.nante.app.service.LookService;
import com.nante.app.service.TailleService;
import com.nante.app.service.TypeService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("gestion")
public class GestionController {

    @Autowired
    private EntityManager em;

    @Autowired
    LookService lookService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TailleService tailleService;

    @GetMapping("/edit-duree-travail")
    public String editDureeTravailView(Model model) {
        List<Look> looks = lookService.findAll();
        model.addAttribute("looks", looks);
        return "benefice/edit-duree-travail.html";
    }

    @PostMapping("/edit-duree-travail")
    @Transactional
    public String editDureeTravail(Model model, @ModelAttribute TempsFabrication tempsFabrication) {
        this.em.createNativeQuery("insert into temps_fabrication (idLook , duree) values ("
                + tempsFabrication.getIdLook() + " , " + tempsFabrication.getDuree() + ")").executeUpdate();
        return "redirect:/gestion/edit-duree-travail";
    }

    @GetMapping("/edit-emp-min")
    public String editEmpMinVew(Model model) {
        return "benefice/edit-emp-min.html";
    }

    @PostMapping("/edit-emp-min")
    @Transactional
    public String editEmpMin(Model model, @ModelAttribute NbrMinEmp nbrMinEmp) {
        nbrMinEmp.insert(this.em);
        return "redirect:/gestion/edit-emp-min";
    }

    @GetMapping("/edit-taux-horaire")
    public String editTauxHoraireView(Model model) {
        return "benefice/edit-taux-horaire.html";
    }

    @PostMapping("/edit-taux-horaire")
    @Transactional
    public String editTauxHoraire(Model model, @ModelAttribute TauxHoraire tauxHoraire) {
        this.em.createNativeQuery("insert into taux_horaire (taux) values (" + tauxHoraire.getTaux() + ")")
                .executeUpdate();
        return "redirect:/gestion/edit-taux-horaire";
    }

    @GetMapping("/ajout-prix-vente")
    public String ajoutPrixVenteView(Model model) {
        List<Type> types = typeService.findAll();
        List<Taille> tailles = tailleService.findAll();
        List<Look> looks = lookService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("tailles", tailles);
        model.addAttribute("looks", looks);
        return "benefice/ajout-prix-vente.html";
    }

    @PostMapping("/ajout-prix-vente")
    @Transactional
    public String ajoutPrixVente(Model model, @ModelAttribute PrixVente prixVente) {
        prixVente.insert(em);
        return "redirect:/gestion/ajout-prix-vente";
    }
}
