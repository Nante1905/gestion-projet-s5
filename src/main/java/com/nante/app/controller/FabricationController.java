package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Fabrication;
import com.nante.app.model.Look;
import com.nante.app.model.Taille;
import com.nante.app.model.Type;
import com.nante.app.service.FormuleFabricationService;
import com.nante.app.service.LookService;
import com.nante.app.service.TailleService;
import com.nante.app.service.TypeService;

@Controller
@RequestMapping("fabrication")
public class FabricationController {

    @Autowired
    private LookService lookService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TailleService tailleService;

    @Autowired
    private FormuleFabricationService formuleFabricationService;

    @GetMapping("/create")
    public String fabricationFormView(Model model) {

        List<Type> types = typeService.findAll();
        List<Look> looks = lookService.findAll();
        List<Taille> tailles = tailleService.findAll();

        model.addAttribute("types", types);
        model.addAttribute("looks", looks);
        model.addAttribute("tailles", tailles);

        return "sacs/fabrication-sac.html";
    }

    @PostMapping("/insert")
    public String fabricationFormProcess(Model model, @ModelAttribute Fabrication fabrication) throws Exception {

        this.formuleFabricationService.fabriquer(fabrication.getIdType(), fabrication.getIdTaille(),
                fabrication.getIdLook(), fabrication.getQte());

        return "redirect:sacs/fabrication-sac.html";
    }
}
