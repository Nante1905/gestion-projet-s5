package com.nante.app.model;

import jakarta.persistence.EntityManager;

public class Client {
    int id;
    String nom;
    int genre;

    public Client(int id, String nom, int genre) {
        setId(id);
        setNom(nom);
        setGenre(genre);
    }

    public Client() {
    }

    public void insert(EntityManager em) throws Exception {
        String query = "insert into client (nom, genre) values (?1, ?2)";
        em.createNativeQuery(query).setParameter(1, this.getNom()).setParameter(2, this.getGenre()).executeUpdate();
    }

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
        if (genre != 0 && genre != 1)
            throw new IllegalArgumentException("Le genre doit être 0 ou 1");
        this.genre = genre;
    }
}
