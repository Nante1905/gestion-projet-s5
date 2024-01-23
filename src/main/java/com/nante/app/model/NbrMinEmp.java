package com.nante.app.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class NbrMinEmp {

    int nbr;
    LocalDate creationDate;

    @Transactional
    public void insert(EntityManager em) {
        List<Taille> tailles = em.createNativeQuery("select * from taille order by ordre", Taille.class)
                .getResultList();

        String query = "insert into nbr_min_emp (nbr) values (?1)";
        em.createNativeQuery(query).setParameter(1, nbr).executeUpdate();

        int min = this.nbr;
        for (Taille taille : tailles) {
            query = "insert into emp_fabrication (id_taille, nbr) values (?1, ?2)";
            em.createNativeQuery(query).setParameter(1, taille.getId()).setParameter(2, min).executeUpdate();
            min = min * 2;
        }
    }

    public NbrMinEmp() {
    }

    public NbrMinEmp(int nbr, Date creationDate) {
        setNbr(nbr);
        setCreationDate(creationDate.toLocalDate());
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}
