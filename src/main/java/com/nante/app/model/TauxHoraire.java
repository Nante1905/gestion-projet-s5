package com.nante.app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TauxHoraire {

    Double taux ;
    LocalDate creationDate ;

    public TauxHoraire() {}

    public TauxHoraire(BigDecimal taux , LocalDate creationDate ) {
        setTaux(taux.doubleValue());
        setCreationDate(creationDate);
    }

    public Double getTaux() {
        return taux;
    }
    public void setTaux(Double taux) {
        this.taux = taux;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}
