package com.nante.app.model;

import java.time.LocalDate;

public class UtilisationMatiere {
    int idMatiere ;
    double qte ;
    LocalDate dateUtilisation ;
    int idFabrication ;
    
    public int getIdMatiere() {
        return idMatiere;
    }
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    public double getQte() {
        return qte;
    }
    public void setQte(double qte) {
        this.qte = qte;
    }
    public LocalDate getDateUtilisation() {
        return dateUtilisation;
    }
    public void setDateUtilisation(LocalDate dateUtilisation) {
        this.dateUtilisation = dateUtilisation;
    }
    public int getIdFabrication() {
        return idFabrication;
    }
    public void setIdFabrication(int idFabrication) {
        this.idFabrication = idFabrication;
    }
}
