package com.nante.app.model;

import java.time.LocalDate;

public class NbrMinEmp {

    int nbr ;
    LocalDate creationDate ;

    public NbrMinEmp() {}

    public NbrMinEmp(int nbr, LocalDate creationDate) {
        setNbr(nbr);
        setCreationDate(creationDate);
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}
