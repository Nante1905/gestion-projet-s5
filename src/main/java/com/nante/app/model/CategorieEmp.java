package com.nante.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Table(name = "categorie_emp")
public class CategorieEmp {
    int id;
    String nom;
    @Column(name = "annee_exp")
    int anneeExp;

    @Column(name = "coef_salaire")
    double coefSalaire;

    public CategorieEmp() {
    }

    public CategorieEmp(int id, String nom, int anneeExp, double coefSalaire) {
        setId(id);
        setNom(nom);
        setAnneeExp(anneeExp);
        setCoefSalaire(coefSalaire);
    }

    @Transactional
    public void insert(EntityManager manager) throws Exception {
        String query = "insert into categorie_emp (nom, annee_exp, coef_salaire) values (?1, ?2, ?3)";

        manager.createNativeQuery(query).setParameter(1, getNom()).setParameter(2, getAnneeExp())
                .setParameter(3, getCoefSalaire()).executeUpdate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnneeExp() {
        return anneeExp;
    }

    public void setAnneeExp(int anneeExp) {
        this.anneeExp = anneeExp;
    }

    public double getCoefSalaire() {
        return coefSalaire;
    }

    public void setCoefSalaire(double coefSalaire) {
        this.coefSalaire = coefSalaire;
    }

}
