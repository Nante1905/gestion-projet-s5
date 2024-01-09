package com.nante.app.model;

import com.nante.app.crud.model.GenericModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Matiere extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    String ref;
    Double pu;

    public Matiere() {
    }

    public Matiere(int id) {
        this.id = id;
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Double getPu() {
        return pu;
    }

    public void setPu(Double pu) {
        this.pu = pu;
    }
}
