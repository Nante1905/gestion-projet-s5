package com.nante.app.model.views;

import java.math.BigDecimal;

import jakarta.persistence.Column;

// @Entity
public class VCoutLookEmp {
    @Column(name = "id_look")
    int idLook;
    @Column(name = "cout_par_emp")
    double coutParEmp;

    public VCoutLookEmp(int idLook, BigDecimal coutParEmp) {
        this.idLook = idLook;
        this.coutParEmp = coutParEmp.doubleValue();
    }

    public int getIdLook() {
        return idLook;
    }

    public void setIdLook(int idLook) {
        this.idLook = idLook;
    }

    public double getCoutParEmp() {
        return coutParEmp;
    }

    public void setCoutParEmp(double coutParEmp) {
        this.coutParEmp = coutParEmp;
    }

}
