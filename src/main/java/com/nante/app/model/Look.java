package com.nante.app.model;

import java.util.ArrayList;
import java.util.List;

import com.nante.app.crud.model.GenericModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Look extends GenericModel {
    @Id
    int id;
    String nom;
    String ref;

    @ManyToMany
    @JoinTable(name = "look_matiere", joinColumns = @JoinColumn(name = "id_look"), inverseJoinColumns = @JoinColumn(name = "id_matiere"))
    List<Matiere> matieres = new ArrayList<>();

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public void addMatiere(Matiere matiere) {
        this.matieres.add(matiere);
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
