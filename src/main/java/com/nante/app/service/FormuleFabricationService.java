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

@Service
public class FormuleFabricationService extends GenericService<FormuleFabrication> {

    @Autowired
    private FormuleFabricationRepository repo;

    @Autowired
    private EntityManager em ;


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

    public void fabriquer(int type , int taille , int look , double qte) throws Exception{
        List<FormuleFabrication> liste_formule= this.em.createNativeQuery("select * from formule_fabrication where id_type = "+type+" and id_taille = "+taille+" and id_look = "+look, FormuleFabrication.class).getResultList();
        List<VStockMatiere> liste_VStock = this.em.createNativeQuery("select * from v_stock_matiere" , VStockMatiere.class).getResultList();
        HashMap<Integer , Double> stock = new HashMap<>();
        for (VStockMatiere vsm : liste_VStock) {
            stock.put(vsm.getIdMatiere(), vsm.getQteRestant());
        }
        for (FormuleFabrication ff : liste_formule) {
            if (stock.get(ff.getId_matiere()) < ff.getQte()) {
                throw new Exception("Stock insuffisante");
            }
        }
    }


}
