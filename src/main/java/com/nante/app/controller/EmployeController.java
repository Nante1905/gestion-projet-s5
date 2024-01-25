package com.nante.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nante.app.model.CategorieEmp;
import com.nante.app.model.Employe;
import com.nante.app.model.views.VEmpThDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("emp")
public class EmployeController {

    @PersistenceContext
    private EntityManager em;

    @GetMapping("")
    public String index(Model model, @RequestParam(name = "min", required = false, defaultValue = "1") String min,
            @RequestParam(name = "max", required = false, defaultValue = "1") String max,
            @RequestParam(name = "type", required = false, defaultValue = "*") String type) {

        int minInt = Integer.parseInt(min);
        int maxInt = Integer.parseInt(max);

        List<CategorieEmp> categorieEmps = this.em.createNativeQuery("select * from categorie_emp", CategorieEmp.class)
                .getResultList();

        List<VEmpThDetail> emps = this.em
                .createNativeQuery("select * from v_emp_th_detail where taux between ?1 and ?2", VEmpThDetail.class)
                .setParameter(1, minInt).setParameter(2, maxInt)
                .getResultList();

        model.addAttribute("categories", categorieEmps);
        model.addAttribute("emps", emps);
        model.addAttribute("page", "emp/list-emp");
        return "layout/index";
    }

    @GetMapping("/ajout")
    public String ajoutEmployeForm(Model model) {
        model.addAttribute("page", "emp/ajout-emp-form");
        return "layout/index";
    }

    @PostMapping("/insert")
    @Transactional
    public String ajoutEmploye(Model model, @ModelAttribute Employe employe) {
        try {
            employe.insert(this.em);
            return "redirect:/emp";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
