package com.nante.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrixVente {
    
    int idType ;
    int idTaille ;
    int idLook ;
    Double prix ;
    LocalDate creationDate ;

    public PrixVente() {}

    public PrixVente(int idType, int idTaille, int idLook , BigDecimal prix , LocalDate creationDate) {
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
