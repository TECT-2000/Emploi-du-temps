/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author Mike Tsebo
 */
public class Domaine {
    
    public ArrayList<Valeur> valeurs;

    public Domaine(ArrayList<Valeur> valeurs) {
        this.valeurs = valeurs;
    }

    @Override
    public String toString() {
        return "Domaine{" + "valeurs=" + valeurs.toString() + '}';
    }
    
    
}
