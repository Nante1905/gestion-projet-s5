package com.nante.app.model.views;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;

public class Benefice {
    @Column(name = "nom_type")
    String type;

    @Column(name = "nom_taille")
    String taille;

    @Column(name = "nom_look")
    String look;

    @Column(name = "prix_vente")
    Double prixVente;

    @Column(name = "prix_reviens")
    Double prixRevient;

    @Column(name = "benefice")
    Double benefice;

    public Benefice(String type, String taille, String look, BigDecimal prixVente, Double prixRevient,
            Double benefice) {
        setType(type);
        setTaille(taille);
        setLook(look);
        setPrixVente(prixVente);
        setPrixRevient(prixRevient);
        setBenefice(benefice);
    }

    public static List<Benefice> getBeneficeBetween(EntityManager em, double min, double max) {
        String query = "select * from v_benefice where benefice between ?1 and ?2";
        List<Benefice> benefices = em.createNativeQuery(query, Benefice.class).setParameter(1, min).setParameter(2, max)
                .getResultList();
        return benefices;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente.doubleValue();
    }

    public Double getPrixRevient() {
        return prixRevient;
    }

    public void setPrixRevient(Double prixRevient) {
        this.prixRevient = prixRevient;
    }

    public void setPrixRevient(BigDecimal prixRevient) {
        this.prixRevient = prixRevient.doubleValue();
    }

    public Double getBenefice() {
        return benefice;
    }

    public void setBenefice(Double benefice) {
        this.benefice = benefice;
    }

    public void setBenefice(BigDecimal benefice) {
        this.benefice = benefice.doubleValue();
    }

}
