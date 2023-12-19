package com.nante.app.model;

import com.nante.app.crud.model.GenericModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Taille extends GenericModel {

    @Id
    int id ;
    String ref ;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
}
