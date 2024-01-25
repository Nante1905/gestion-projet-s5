package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nante.app.model.Client;
import com.nante.app.model.Look;
import com.nante.app.model.Sac;
import com.nante.app.model.Taille;
import com.nante.app.model.Type;
import com.nante.app.model.views.VSacPrix;
import com.nante.app.service.LookService;
import com.nante.app.service.TailleService;
import com.nante.app.service.TypeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
@RequestMapping("/sacs")
public class SacController {

    @Autowired
    LookService lookService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TailleService tailleService;

    @PersistenceContext()
    private EntityManager em;

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1", name = "min") String minStr,
            @RequestParam(defaultValue = "1", name = "max") String maxStr,
            Model model) throws Exception {

        try {
            double min = Double.valueOf(minStr);
            double max = Double.valueOf(maxStr);

            List<VSacPrix> sacs = VSacPrix.findAllSacsBetween(min, max, em);

            model.addAttribute("sacs", sacs);
            System.out.println("debugggggggg " + sacs.size());

            return "sacs/liste-sac-prix";

        } catch (NumberFormatException nbFormatE) {
            throw new NumberFormatException("Les valeurs min et max doivent être des nombres");
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/ajout")
    public String ajouterSac(Model model) {
        List<Type> types = typeService.findAll();
        List<Taille> tailles = tailleService.findAll();
        List<Look> looks = lookService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("tailles", tailles);
        model.addAttribute("looks", looks);
        model.addAttribute("page", "ajout-sac");
        return "layout/index";
    }

}
