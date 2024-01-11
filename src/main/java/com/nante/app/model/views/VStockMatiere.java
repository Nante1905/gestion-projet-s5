package com.nante.app.model.views;

public class VStockMatiere {
    int idMatiere ;
    String nomMatiere ;
    double qteRestant ;

    public int getIdMatiere() {
        return idMatiere;
    }
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
    public String getNomMatiere() {
        return nomMatiere;
    }
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }
    public double getQteRestant() {
        return qteRestant;
    }
    public void setQteRestant(double qteRestant) {
        this.qteRestant = qteRestant;
    }
}
