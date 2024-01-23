package com.nante.app.model.views;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;

public class VCoutMateriauxEmp {
    @Column(name = "id_type")
    int idType;

    @Column(name = "nom_type")
    String nomType;

    @Column(name = "id_taille")
    int idTaille;

    @Column(name = "nom_taille")
    String nomTaille;

    @Column(name = "id_look")
    int idLook;

    @Column(name = "nom_look")
    String nomLook;

    double prix;

    @Column(name = "cout_par_emp")
    double coutParEmp;

    @Column(name = "prix_vente")
    double prixVente;

    @Transient
    int nbrPerson;

    public double getBenefice() {
        double prixRevient = this.prix + (this.coutParEmp * this.nbrPerson);
        double benefice = this.prixVente - prixRevient;
        return benefice;
    }

    public int getNbrPerson() {
        return nbrPerson;
    }

    public void setNbrPerson(int nbrPerson) {
        this.nbrPerson = nbrPerson;
    }

    public VCoutMateriauxEmp(int idType, String nomType, int idTaille, String nomTaille, int idLook, String nomLook,
            double prix, BigDecimal coutParEmp, BigDecimal prixVente) {
        this.idType = idType;
        this.nomType = nomType;
        this.idTaille = idTaille;
        this.nomTaille = nomTaille;
        this.idLook = idLook;
        this.nomLook = nomLook;
        this.prix = prix;
        this.coutParEmp = coutParEmp.doubleValue();
        this.prixVente = prixVente.doubleValue();
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getCoutParEmp() {
        return coutParEmp;
    }

    public void setCoutParEmp(double coutParEmp) {
        this.coutParEmp = coutParEmp;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public String getNomTaille() {
        return nomTaille;
    }

    public void setNomTaille(String nomTaille) {
        this.nomTaille = nomTaille;
    }

    public String getNomLook() {
        return nomLook;
    }

    public void setNomLook(String nomLook) {
        this.nomLook = nomLook;
    }

}
