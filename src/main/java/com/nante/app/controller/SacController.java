package com.nante.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nante.app.model.views.VSacPrix;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
@RequestMapping("/sacs")
public class SacController {

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

            return "";

        } catch (NumberFormatException nbFormatE) {
            throw new NumberFormatException("Les valeurs min et max doivent être des nombres");
        } catch (Exception e) {
            throw new Exception("Une erreur est survenue");
        }
    }
}
