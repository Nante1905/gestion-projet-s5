package com.nante.app.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nante.app.model.NbrMinEmp;
import com.nante.app.model.Taille;
import com.nante.app.model.views.VCoutMateriauxEmp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class BeneficeService {

    @PersistenceContext
    private EntityManager em;

    public void getBeneficeParSac() {
        List<VCoutMateriauxEmp> coutMateriauxEmps = this.em
                .createNativeQuery("select * from v_cout_materiaux_emp", VCoutMateriauxEmp.class).getResultList();

        NbrMinEmp nbrMinEmp = (NbrMinEmp) this.em.createNativeQuery("select * from v_last_nbr_min_emp", NbrMinEmp.class)
                .getSingleResult();
        List<Taille> tailles = this.em.createNativeQuery("select * from taille order by ordre", Taille.class)
                .getResultList();

        int prevValue = 1;
        HashMap<Integer, Integer> tailleNbrPerson = new HashMap<>();
        for (Taille taille : tailles) {
            int nbrPerson = prevValue * nbrMinEmp.getNbr();
            tailleNbrPerson.put(taille.getId(), nbrPerson);

            prevValue = nbrPerson;
        }
        tailleNbrPerson.forEach((k, v) -> System.out.println(k + " " + v));

        for (VCoutMateriauxEmp vCoutMateriauxEmp : coutMateriauxEmps) {
            vCoutMateriauxEmp.setNbrPerson(tailleNbrPerson.get(vCoutMateriauxEmp.getIdTaille()));
        }

        coutMateriauxEmps.stream().forEach(c -> System.out
                .println(c.getNomLook() + " " + c.getNomTaille() + " " + c.getNomType() + " " + c.getBenefice()));
    }
}
