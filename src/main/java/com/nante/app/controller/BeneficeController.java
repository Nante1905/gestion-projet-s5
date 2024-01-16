package com.nante.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gestion")
public class BeneficeController {

    @GetMapping("/benef")
    public String benefView(Model model) {
        return "benef.html";
    }
}
