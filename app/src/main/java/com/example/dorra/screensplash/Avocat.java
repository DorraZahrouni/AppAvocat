package com.example.dorra.screensplash;

/**
 * Created by Tej Eddine on 24/01/2017.
 */

public class Avocat {
    private String mail;
    private String password;
    private String nom;
    private String prenom;
    private String cheminPhoto;

    public Avocat(String mail, String password, String nom, String prenom, String cheminPhoto) {
        this.mail = mail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.cheminPhoto = cheminPhoto;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCheminPhoto() {
        return cheminPhoto;
    }

    public void setCheminPhoto(String cheminPhoto) {
        this.cheminPhoto = cheminPhoto;
    }
}