package com.nante.app.controller;

import java.time.LocalDate;
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

import com.nante.app.model.AchatMatiere;
import com.nante.app.model.Look;
import com.nante.app.model.Matiere;
import com.nante.app.model.views.VStockMatiere;
import com.nante.app.repository.FournisseurRepository;
import com.nante.app.service.LookService;
import com.nante.app.service.MatiereService;
import com.nante.app.types.MatierePrixDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("matieres")
public class MatiereController {
    @Autowired
    private LookService lookService;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @PersistenceContext
    private EntityManager em;

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
        return "matiere/update-pu.html";
    }

    @PostMapping("/update-pu")
    @Transactional()
    public String updatePuMatiereVue(MatierePrixDto matierePrixDto) throws Exception {
        if (matierePrixDto.getPrix() < 0) {
            throw new Exception("Le prix ne peut pas être négatif");
        }
        Matiere m = this.matiereService.find(matierePrixDto.getIdMatiere());
        m.setPu(matierePrixDto.getPrix());
        this.matiereService.save(m);
        em.createNativeQuery("insert into historique_pu (id_matiere, date_pu, valeur) values (?1, now(), ?2)")
                .setParameter(1, matierePrixDto.getIdMatiere())
                .setParameter(2, matierePrixDto.getPrix()).executeUpdate();
        return "redirect:/matieres/update-pu";
    }

    @GetMapping("/achat")
    public String achatMatiereView(Model model) {
        List<Matiere> matieres = this.matiereService.findAll();
        List<?> fournisseurs = this.fournisseurRepository.findAll();

        model.addAttribute("matieres", matieres);
        model.addAttribute("fournisseurs", fournisseurs);

        return "matiere/achat-matiere";
    }

    @PostMapping("/achat/process")
    @Transactional
    public String achatMatiere(Model model, @ModelAttribute AchatMatiere achatMatiere) throws Exception {

        achatMatiere.setDateAchat(LocalDate.now());

        em.createNativeQuery(
                "insert into achat_matiere (id_matiere, qte, id_fournisseur, date_achat) values (?1, ?2, ?3, ?4)")
                .setParameter(1, achatMatiere.getIdMatiere())
                .setParameter(2, achatMatiere.getQte())
                .setParameter(3, achatMatiere.getIdFournisseur())
                .setParameter(4, achatMatiere.getDateAchat())
                .executeUpdate();

        return "redirect:/matiere/achat-matiere";
    }

    @GetMapping("/stock")
    public String stock(Model model) {
        List<VStockMatiere> stockMatieres = this.em
                .createNativeQuery("select * froma v_stock_matiere", VStockMatiere.class).getResultList();

        model.addAttribute("stocks", stockMatieres);

        return "matiere/stock-matiere.html";
    }
}
