package com.nante.app.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.nante.app.crud.model.GenericModel;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FormuleFabrication extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;

    int id_taille;
    int id_type;
    int id_matiere;
    int id_look;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taille", insertable = false, updatable = false)
    Taille taille;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type", insertable = false, updatable = false)
    Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matiere", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    Matiere matiere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_look", insertable = false, updatable = false)
    Look look;
    Double qte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Look getLook() {
        return look;
    }

    public void setLook(Look look) {
        this.look = look;
    }

    public Double getQte() {
        return qte;
    }

    public void setQte(Double qte) {
        this.qte = qte;
    }

    public int getId_taille() {
        return id_taille;
    }

    public void setId_taille(int id_taille) {
        this.id_taille = id_taille;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public int getId_look() {
        return id_look;
    }

    public void setId_look(int id_look) {
        this.id_look = id_look;
    }

}
