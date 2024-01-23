package com.nante.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class PrixVente {

    int idType;
    int idTaille;
    int idLook;
    Double prix;
    LocalDate creationDate;

    @Transactional
    public void insert(EntityManager em) {
        em.createNativeQuery(
                "insert into prix_vente (id_type , id_taille , id_look , prix) values (" + this.getIdType() + " , "
                        + this.getIdTaille() + " , " + this.getIdLook() + " , " + this.getPrix() + ")")
                .executeUpdate();
    }

    public PrixVente() {
    }

    public PrixVente(int idType, int idTaille, int idLook, BigDecimal prix, LocalDate creationDate) {
        setIdType(idType);
        setIdTaille(idTaille);
        setIdLook(idLook);
        setPrix(prix.doubleValue());
        setCreationDate(creationDate);
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(int idTaille) {
        this.idTaille = idTaille;
    }

    public int getIdLook() {
        return idLook;
    }

    public void setIdLook(int idLook) {
        this.idLook = idLook;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
