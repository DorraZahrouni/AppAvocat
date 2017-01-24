package com.example.dorra.screensplash;

import java.sql.Date;

/**
 * Created by Tej Eddine on 24/01/2017.
 */

public class Dossier {
    private Date dateAcceptaion;
    private String idDossier;
    private String couleur;
    private String remarques;
    private String type;

    public Date getDateAcceptaion() {
        return dateAcceptaion;
    }

    public void setDateAcceptaion(Date dateAcceptaion) {
        this.dateAcceptaion = dateAcceptaion;
    }

    public String getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(String idDossier) {
        this.idDossier = idDossier;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
