package com.nante.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.nante.app.model.Look;
import com.nante.app.model.Taille;
import com.nante.app.model.Type;
import com.nante.app.service.LookService;
import com.nante.app.service.TailleService;
import com.nante.app.service.TypeService;



@Controller
public class FormuleFabricationController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private TailleService tailleService;
    
    @Autowired
    private LookService lookService;
    
    public String formuleFabricationForm(Model model) {
        List<Type> types = this.typeService.findAll();
        List<Taille> tailles = this.tailleService.findAll();
        List<Look> looks = this.lookService.findAll();
        model.addAttribute(types);
        model.addAttribute(tailles);
        model.addAttribute(looks);
        return "";
    }

}
