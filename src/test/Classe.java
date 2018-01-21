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
public class Classe {
    
    
    private int nbre_eleves;
    private String nom_classe;

    public Classe(int nbre_eleves, String nom_classe) {
        this.nbre_eleves = nbre_eleves;
        this.nom_classe = nom_classe;
    }

    
    public int getNbre_eleves() {
        return nbre_eleves;
    }

    public void setNbre_eleves(int nbre_eleves) {
        this.nbre_eleves = nbre_eleves;
    }

    public String getNom_classe() {
        return nom_classe;
    }

    public void setNom_classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }
    
    
}









