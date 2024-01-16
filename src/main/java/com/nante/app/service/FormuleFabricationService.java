package com.nante.app.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nante.app.crud.service.GenericService;
import com.nante.app.model.FormuleFabrication;
import com.nante.app.model.views.VStockMatiere;
import com.nante.app.repository.FormuleFabricationRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class FormuleFabricationService extends GenericService<FormuleFabrication> {

    @Autowired
    private FormuleFabricationRepository repo;

    @Autowired
    private EntityManager em;

    // public FormuleFabrication save(FormuleFabrication f) {
    // this.repo.save(f.getTaille().getId(), f.getType().getId(),
    // f.getMatiere().getId(), f.getLook().getId(),
    // f.getQte());
    // return null;
    // }

    public List<FormuleFabrication> findByIdMatiere(int id) {
        return repo.findByMatiere_Id(id);
    }

    public FormuleFabrication findWithLook(int ffId) {
        return this.repo.findWithLook(ffId);
    }

    @Transactional
    public void fabriquer(int type, int taille, int look, double qte) throws Exception {
        List<FormuleFabrication> liste_formule = this.em
                .createNativeQuery("select * from formule_fabrication where id_type = " + type + " and id_taille = "
                        + taille + " and id_look = " + look, FormuleFabrication.class)
                .getResultList();

        if (liste_formule.size() <= 0) {
            throw new Exception("Formule inexistant");
        }

        List<VStockMatiere> liste_VStock = this.em
                .createNativeQuery("select vsm.*, m.nom from v_stock_matiere vsm join matiere m on m.id=vsm.id_matiere",
                        VStockMatiere.class)
                .getResultList();

        HashMap<Integer, Double> stock = new HashMap<>();
        for (VStockMatiere vsm : liste_VStock) {
            stock.put(vsm.getIdMatiere(), vsm.getQteRestant());
        }

        for (FormuleFabrication ff : liste_formule) {
            if (stock.get(ff.getId_matiere()) < ff.getQte()) {
                throw new Exception("Stock insuffisante");
            }
        }

        int id = (int) this.em
                .createNativeQuery(
                        "insert into fabrication (id_type, id_taille, id_look, qte, date_fabrication) values (" + type
                                + "," + taille + "," + look + "," + qte + ",now()) returning id")
                .getSingleResult();
        for (FormuleFabrication ff : liste_formule) {
            this.em.createNativeQuery(
                    "insert into utilisation_matiere (id_matiere, qte, date_utilisation, id_fabrication) values ("
                            + ff.getId_matiere() + ","
                            + ff.getQte() * qte + ",now()," + id + ")")
                    .executeUpdate();
        }
    }

}
