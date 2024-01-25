package com.nante.app.model;

public class Client {
    int id ;
    String nom ;
    int genre ;

    public Client(int id, String nom, int genre) {
        setId(id);
        setNom(nom);
        setGenre(genre);
    }
    public Client() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getGenre() {
        return genre;
    }
    public void setGenre(int genre) {
        this.genre = genre;
    }
}
