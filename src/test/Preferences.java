/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Mike Tsebo
 */
public class Preferences {
 
    private String salle;
    private String professeur;
    private String jour;
    private int heure;
    
    public Preferences( String professeur,String salle, String jour, int heure) {
        this.salle = salle;
        this.professeur = professeur;
        this.jour = jour;
        this.heure = heure;
    }

    public Preferences(String salle, String jour, int heure) {
        this.salle = salle;
        this.jour = jour;
        this.heure = heure;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
    
    
    
}
