package com.nante.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("type")
public class TypeController {

    @GetMapping("/create")
    public String create(Model model) {
        return "";
    }

    @PostMapping("/insert")
    public String insert(Model model) {
        return "";
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
