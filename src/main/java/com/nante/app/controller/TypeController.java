package com.nante.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nante.app.model.Type;
import com.nante.app.service.TypeService;

@Controller
@RequestMapping("type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/create")
    public String create(Model model) {
        return "creation-type";
    }

    @PostMapping("/insert")
    public String insert(Model model, @ModelAttribute Type type) {
        this.typeService.save(type);
        return "redirect:/type/create";
    }

    // @PostMapping("/insert")
    // public String insert(Model model, @ModelAttribute FormuleFabricationDto
    // params) {
    // // new FormFab with dto
    // // try
    // // save

    // return "";
    // }
}
