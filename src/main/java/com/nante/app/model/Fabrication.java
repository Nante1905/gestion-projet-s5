package com.nante.app.model;

import java.time.LocalDate;

public class Fabrication {
    int idType ;
    int idTaille ;
    int idLook ;
    double qte ;
    LocalDate dateFabrication ;
    int id ;
    
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
    public double getQte() {
        return qte;
    }
    public void setQte(double qte) {
        this.qte = qte;
    }
    public LocalDate getDateFabrication() {
        return dateFabrication;
    }
    public void setDateFabrication(LocalDate dateFabrication) {
        this.dateFabrication = dateFabrication;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
