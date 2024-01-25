package com.nante.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vente {
    int idSac ;
    int idClient ;
    LocalDate dateVente ;
    Double nombre ;

    public Vente(int idSac , int idClient , LocalDate dateVente , BigDecimal nombre) {
        setIdSac(idSac);
        setIdClient(idClient);
        setDateVente(dateVente);
        setNombre(nombre.doubleValue());
    }
    public Vente() {}

    public int getIdSac() {
        return idSac;
    }
    public void setIdSac(int idSac) {
        this.idSac = idSac;
    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public LocalDate getDateVente() {
        return dateVente;
    }
    public void setDateVente(LocalDate dateVente) {
        this.dateVente = dateVente;
    }
    public Double getNombre() {
        return nombre;
    }
    public void setNombre(Double nombre) {
        this.nombre = nombre;
    }
}
