package com.nante.app.model;

import com.nante.app.crud.model.GenericModel;

import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "id_taille")
    Taille taille;

    @ManyToOne
    @JoinColumn(name = "id_type")
    Type type;

    @ManyToOne
    @JoinColumn(name = "id_matiere")
    Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "id_look")
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

}
