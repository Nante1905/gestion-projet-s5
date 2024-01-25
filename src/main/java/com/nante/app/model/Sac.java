package com.nante.app.model;

public class Sac {
    int id ;
    int idType ;
    int idTaille ;
    int idLook ;
    String nom ;

    public Sac(int id , int idType , int idTaille , int idLook , String nom) {
        setId(id);
        setIdType(idType);
        setIdTaille(idTaille);
        setIdLook(idLook);
        setNom(nom);
    }
    public Sac() {}

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
