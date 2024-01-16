package com.nante.app.model.views;

import java.math.BigDecimal;

public class VStockMatiere {
    int idMatiere;
    String nomMatiere;
    double qteRestant;

    public VStockMatiere(int idMatiere, BigDecimal qteRestant, String nomMatiere) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.qteRestant = qteRestant.doubleValue();
    }

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
