/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mike Tsebo
 */
public class Professeur {

    public SimpleStringProperty nom = new SimpleStringProperty(this, "nom");
    public UE matiereDuProf;
    public ArrayList<Preferences> preferences=new ArrayList<>();

    public Professeur(String nom,UE matiere) {
        setNom(nom);
        matiereDuProf=matiere;
}

    public ArrayList<Preferences> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<Preferences> preferences) {
        this.preferences = preferences;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String name) {
        this.nom.set(name);
    }

    boolean prefer(Variable var) {
        if (preferences.size() == 0) {
            return true;
        } else {
            for (Preferences p : preferences) {
                if (var.jour.toString() == p.getJour() && var.heure == p.getHeure()) {
                    return true;
                }
            }
            return false;
        }
    }

}
