package com.nante.app.model.views;

import java.util.List;

import jakarta.persistence.EntityManager;

public class VSacPrix {
    String typeNom;
    String taille;
    String look;
    double prix;

    public VSacPrix(String typeNom, String taille, String look, double prix) {
        this.typeNom = typeNom;
        this.taille = taille;
        this.look = look;
        this.prix = prix;
    }

    public static List<VSacPrix> findAllSacsBetween(double min, double max, EntityManager em) {
        return em.createNativeQuery("select * from v_sac_prix where prix between ?1 and ?2", VSacPrix.class)
                .setParameter(1, min).setParameter(2, max).getResultList();
    }

    public String getType() {
        return typeNom;
    }

    public void setType(String type) {
        this.typeNom = type;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
