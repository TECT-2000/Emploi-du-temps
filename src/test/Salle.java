/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mike Tsebo
 */
public class Salle {
    
    public SimpleIntegerProperty capacite = new SimpleIntegerProperty(this, "capacite");
    public SimpleStringProperty nom = new SimpleStringProperty(this, "nom");
    

    public Salle( String nom, int capacite) {
        
        setNom(nom);
        setCapacite(capacite);
    }
    
    public Salle( String nom) {
        
        setNom(nom);
        
    }

    public Integer getCapacite() {
        return capacite.get();
    }

    public void setCapacite(int capacite) {
            this.capacite.set(capacite);
        }

    public String getNom() {
            return nom.get();
        }

    public void setNom(String name) {
            this.nom.set(name);
        }
    
    
    
}










