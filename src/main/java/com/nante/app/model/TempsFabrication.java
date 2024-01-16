package com.nante.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TempsFabrication {

    int idLook ;
    Double duree ;
    LocalDate creationDate ;

    public TempsFabrication() {}

    public TempsFabrication(int idLook , BigDecimal duree , LocalDate creationDate) {
        setIdLook(idLook);
        setDuree(duree.doubleValue());
        setCreationDate(creationDate);
    }

    public int getIdLook() {
        return idLook;
    }
    public void setIdLook(int idLook) {
        this.idLook = idLook;
    }
    public double getDuree() {
        return duree;
    }
    public void setDuree(double duree) {
        this.duree = duree;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


}
