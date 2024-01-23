package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nante.app.model.FormuleFabrication;
import com.nante.app.model.Look;
import com.nante.app.model.Matiere;
import com.nante.app.model.Taille;
import com.nante.app.model.Type;
import com.nante.app.service.FormuleFabricationService;
import com.nante.app.service.LookService;
import com.nante.app.service.MatiereService;
import com.nante.app.service.TailleService;
import com.nante.app.service.TypeService;
import com.nante.app.types.FormuleFabricationDto;

@Controller
@RequestMapping("formule-fab")
public class FormuleFabricationController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private TailleService tailleService;

    @Autowired
    private LookService lookService;
    @Autowired
    private MatiereService matiereService;

    @Autowired
    private FormuleFabricationService fabricationService;

    @GetMapping("")
    public String list(Model model, @RequestParam(defaultValue = "1") String idMatiere) throws Exception {
        int id = 0;
        try {
            id = Integer.valueOf(idMatiere);
        } catch (Exception e) {
            throw new Exception("Invalid Parameter " + e.getMessage());
        }
        List<FormuleFabrication> fabrications = this.fabricationService.findByIdMatiere(id);
        List<Matiere> matieres = this.matiereService.findAll();

        // FormuleFabrication f1 = this.fabricationService.find(5);
        // System.out.println(f1.getLook().getNom());

        System.out.println("debug =================================== ");
        model.addAttribute("matieres", matieres);

        model.addAttribute("fabrications", fabrications);
        model.addAttribute("page", "formule-fabrication-list");
        return "layout/index";
    }

    @GetMapping("/create")
    public String formuleFabricationForm(Model model) {
        List<Type> types = this.typeService.findAll();
        List<Matiere> matieres = this.matiereService.findAll();
        List<Taille> tailles = this.tailleService.findAll();
        List<Look> looks = this.lookService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("matieres", matieres);
        model.addAttribute("tailles", tailles);
        model.addAttribute("looks", looks);
        model.addAttribute("page", "formule-fabrication-form");
        return "layout/index";
    }

    @PostMapping("/insert")
    public String insert(Model model, @ModelAttribute FormuleFabricationDto params) throws Exception {

        // Look look = new Look();
        // look.setId(params.getIdLook());

        // Type type = new Type();
        // type.setId(params.getIdType());

        // Taille taille = new Taille();
        // taille.setId(params.getIdTaille());

        // Matiere matiere = new Matiere();
        // matiere.setId(params.getIdMatiere());

        FormuleFabrication fabrication = new FormuleFabrication();
        fabrication.setId_look(params.getIdLook());
        fabrication.setId_matiere(params.getIdMatiere());
        fabrication.setId_taille(params.getIdTaille());
        fabrication.setId_type(params.getIdType());
        fabrication.setQte(params.getQte());

        this.fabricationService.save(fabrication);

        return "redirect:/formule-fab/create";
    }
    // @PostMapping("/insert")
    // public String insert(Model model, @ModelAttribute FormuleFabricationDto
    // params) throws Exception {

    // Look look = new Look();
    // look.setId(params.getIdLook());

    // Type type = new Type();
    // type.setId(params.getIdType());

    // Taille taille = new Taille();
    // taille.setId(params.getIdTaille());

    // Matiere matiere = new Matiere();
    // matiere.setId(params.getIdMatiere());

    // FormuleFabrication fabrication = new FormuleFabrication();
    // fabrication.setLook(look);
    // fabrication.setMatiere(matiere);
    // fabrication.setTaille(taille);
    // fabrication.setType(type);
    // fabrication.setQte(params.getQte());

    // this.fabricationService.save(fabrication);

    // return "redirect:/formule-fab/create";
    // }

}
