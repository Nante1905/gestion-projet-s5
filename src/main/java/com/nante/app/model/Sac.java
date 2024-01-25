package com.nante.app.model;

import jakarta.persistence.EntityManager;

public class Sac {
    int id;
    int idType;
    int idTaille;
    int idLook;
    String nom;

    public Sac(int id, int idType, int idTaille, int idLook, String nom) {
        setId(id);
        setIdType(idType);
        setIdTaille(idTaille);
        setIdLook(idLook);
        setNom(nom);
    }

    public Sac() {
    }

    public void insert(EntityManager em) throws Exception {
        em.createNativeQuery("insert into sac (id_type, id_taille, id_look, nom) values (?1,?2,?3,?4)")
                .setParameter(1, this.getIdType()).setParameter(2, this.getIdLook()).setParameter(3, this.getIdLook())
                .setParameter(4, this.getNom()).executeUpdate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
