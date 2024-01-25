package com.nante.app.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;

public class Employe {
    int id;
    String nom;
    String prenom;

    @Column(name = "date_embauche")
    LocalDate dateEmbauche;

    public Employe() {
    }

    public Employe(int id, String nom, String prenom, LocalDate dateEmbauche) {
        setId(id);
        setNom(prenom);
        setPrenom(prenom);
        setDateEmbauche(dateEmbauche);
    }

    public static void findEmpWithPostAndTh(EntityManager em) {

    }

    public void insert(EntityManager manager) throws Exception {
        String query = "insert into employe (nom, prenom, date_embauche) values (?1, ?2, ?3)";

        manager.createNativeQuery(query).setParameter(1, getNom()).setParameter(2, getPrenom())
                .setParameter(3, getDateEmbauche()).executeUpdate();
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

}
