package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nante.app.model.Look;
import com.nante.app.model.Matiere;
import com.nante.app.service.LookService;
import com.nante.app.service.MatiereService;
import com.nante.app.types.MatierePrixDto;

@Controller
@RequestMapping("matieres")
public class MatiereController {
    @Autowired
    private LookService lookService;

    @Autowired
    private MatiereService matiereService;

    @GetMapping("/create")
    public String insererMatiereVue(Model model) {
        return "matiere/creation-matiere.html";
    }

    @PostMapping("/insert")
    public String insererMatiere(Model model, @ModelAttribute Matiere m) {
        this.matiereService.save(m);
        return "redirect:/matieres/look";
    }

    @GetMapping("/look")
    public String findMatieresByIdLook(Model model, @RequestParam(defaultValue = "1") String idLook)
            throws NotFoundException {
        try {
            List<Look> looks = lookService.findAll();
            List<Matiere> matieres = lookService.findMatieresOf(Integer.parseInt(idLook));
            model.addAttribute("matieres", matieres);
            model.addAttribute("looks", looks);
            return "matiere/matieres.html";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/update-pu")
    public String updatePuMatiereVue(Model model) {
        List<Matiere> matieres = this.matiereService.findAll();
        model.addAttribute("matieres", matieres);
        return "";
    }

    @PostMapping("/update-pu")
    public String updatePuMatiereVue(MatierePrixDto matierePrixDto) throws NotFoundException {
        Matiere m = this.matiereService.find(matierePrixDto.getIdMatiere());
        m.setPu(matierePrixDto.getPrix());
        this.matiereService.save(m);
        return "redirect:/matieres/update-pu";
    }
}
