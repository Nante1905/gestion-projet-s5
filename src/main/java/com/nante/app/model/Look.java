package com.nante.app.model;

import java.util.List;

import com.nante.app.crud.model.GenericModel;

public class Look extends GenericModel {
    int id ;
    String nom ;
    String ref ;
    List<Matiere> matieres ;

    public List<Matiere> getMatieres() {
        return matieres;
    }
    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
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
}
