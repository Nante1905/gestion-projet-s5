package com.nante.app.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HistoriquePu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int idMatiere;
    LocalDate datePu;
    Double valeur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public LocalDate getDatePu() {
        return datePu;
    }

    public void setDatePu(LocalDate datePu) {
        this.datePu = datePu;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

}
